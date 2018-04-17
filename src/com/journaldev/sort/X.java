package com.journaldev.sort;
interface X {
       String f();
}
class X1 implements X {
       @Override
       public String f() {
              return "x1";
       }
}
class X2 implements X {
       @Override
       public String f() {
              return "x2";
       }
}
class C {
       public static X createX (String itype) {
       if (itype.equalsIgnoreCase ("X1")){
              return new X1();
       } else if(itype.equalsIgnoreCase ("X2")){
              return new X2();
       } else {
           throw new IllegalArgumentException("No such type");
       }
}
}