module.exports = {
  // entry: 'D:/JavaScriptProject/projects/my_react_project/main.js',
  entry: './main.js',
  output: {
    // path: './',
    // path: 'D:/JavaScriptProject/projects/my_react_project/',
    filename: 'index.js'
  },
  devServer:{
    inline: true,
    port:3333
  },
  module:{
    loaders:[
      {test: /\.jsx?$/, exclude: /node_modules/, loader: 'babel'}
    ]
  }
};