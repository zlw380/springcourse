package org.example.excep;

public class NotEnoughException extends RuntimeException{
    //子类构造方法调用父类构造方法，先有老子后有儿子,但对象只创建了一个
    public NotEnoughException() {
        super();
    }

    public NotEnoughException(String message) {
        super(message);
    }
}
