package org.example;

/**
 * 7种单例设计模式
 * 1.饿汉式
 * 2.懒汉式
 * 3.懒汉式+同步方法
 * 4.Double check
 * 5.Holder 方式
 * 6.Enum 方式
 * 7.Enum Holder
 */
public class SingletonClass {
    //懒汉式单例
    public static class StarvingSingleton {
        private static final StarvingSingleton INSTANCE = new StarvingSingleton();

        private StarvingSingleton(){}

        public static StarvingSingleton getInstance(){
            return INSTANCE;
        }
    }

    //懒汉式单例
    public static class LazyBoneSingleton{
        private static LazyBoneSingleton INSTANCE;

        private LazyBoneSingleton(){}

        public static LazyBoneSingleton getInstance(){
            if (INSTANCE == null){
                INSTANCE = new LazyBoneSingleton();
            }
            return INSTANCE;
        }
    }

    //懒汉式单例+同步方法
    public static class LazyBoneSynchronizedSingleton{
        private static LazyBoneSynchronizedSingleton INSTANCE;

        private LazyBoneSynchronizedSingleton(){}

        public static synchronized LazyBoneSynchronizedSingleton getInstance(){
            if (null == INSTANCE){
                INSTANCE = new LazyBoneSynchronizedSingleton();
            }
            return INSTANCE;
        }
    }

    //Double-check
    public static class DoubleCheckSingleton{
        private volatile static DoubleCheckSingleton INSTANCE ;

        private DoubleCheckSingleton(){}

        public static DoubleCheckSingleton getInstance(){
            if (null == INSTANCE){
                synchronized (DoubleCheckSingleton.class){
                    if (null == INSTANCE ){
                        INSTANCE = new DoubleCheckSingleton();
                    }
                }
            }
            return INSTANCE;
        }
    }

    //Holder
    public static  class  HolderSingleton{
        private  HolderSingleton(){}

        private static class Holder{
            private  static HolderSingleton instance = new HolderSingleton();

            public static HolderSingleton getInstance(){
                return Holder.instance;
            }
        }
    }

    //Enum
    public enum EnumSingleton{
        INSTANCE;

        public static EnumSingleton getInstance(){
            return INSTANCE;
        }
    }

    //Enum Holder
    public static class EnumHolderSingleton{
        private EnumHolderSingleton(){}

        private enum EnumHolder{
            INSTANCE;
            private EnumHolderSingleton instance;

            EnumHolder(){
                this.instance = new EnumHolderSingleton();
            }

            private EnumHolderSingleton getInstance(){
                return instance;
            }
        }

        public static EnumHolderSingleton getInstance(){
            return EnumHolder.INSTANCE.getInstance();
        }
    }
}
