import React, { Component } from 'react';
import Game from './Game.jsx';



const style = {

    square: {
        "background":"#fff",
        "border":"1px solid #999",
        "float":"left",
        "fontSize":"24px",
        "fontWeight":"bold",
        "lineHeight":"34px",
        "height":"34px",
        "marginRight":"-1px",
        "marginTop":"-1px",
        "padding":"0",
        "textAlign":"center",
        "width":"34px",
        "focus":{
            "outline":"none"
        }
    },

    board: {
        "display":"flex",
        "flexDirection":"column"
    }
}



function Square(props) {
    // debugger;
    return (
        <button className="square" onClick={props.onClick} style={style.square}>
            {props.value}
        </button>
    );
}

class App extends Component {


    constructor(props) {
        super(props);
        this.state = {
            squares: Array(9).fill(null),
            xIsNext: true
        };
        // alert('Hi');
    }


    handleClick(i) {
        const squares = this.state.squares.slice();

        if (calculateWinner(squares) || squares[i]) {
            return;
        }

        squares[i] = this.state.xIsNext ? 'X' : 'O';
        this.setState({
            squares: squares,
            xIsNext: !this.state.xIsNext,
        });
    }



    renderSquare(i) {
        return (
            <Square 
                value={this.state.squares[i]} 
                onClick={() => this.handleClick(i)}
            />
        );
    }

    render() {

        const winner = calculateWinner(this.state.squares);
        let status;
        if (winner) {
            status = 'Winner: ' + winner;
        } else {
            status = 'Next player: ' + (this.state.xIsNext ? 'X' : 'O');
        }

        return (
            <div>
                <div className="status">{status}</div>
                <div className="board"  style={style.board}>
                    <div className="board-row">
                      {this.renderSquare(0)}
                      {this.renderSquare(1)}
                      {this.renderSquare(2)}
                    </div>
                    <div className="board-row">
                      {this.renderSquare(3)}
                      {this.renderSquare(4)}
                      {this.renderSquare(5)}
                    </div>
                    <div className="board-row">
                      {this.renderSquare(6)}
                      {this.renderSquare(7)}
                      {this.renderSquare(8)}
                    </div>
                    
                </div>
            </div>
        );
    }
}


function calculateWinner(squares) {
  const lines = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6],
  ];
  for (let i = 0; i < lines.length; i++) {
    const [a, b, c] = lines[i];
    if (squares[a] && squares[a] === squares[b] && squares[a] === squares[c]) {
      return squares[a];
    }
  }
  return null;
}

export default App;