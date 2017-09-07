import java.lang.reflect.InvocationHandler;

public class InHandler implements InvocationHandler {

    private Object obj;

    public InHandler(Object f1){ obj = f1; }

    public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args)
            throws Throwable {
        System.out.println("InHandler invoke : " + method.getName());
        return method.invoke(obj, args) ;
    }


}
