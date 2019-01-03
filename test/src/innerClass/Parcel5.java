package innerClass;

import InterFace.UserManager;

/*
 * 静态内部类实现接口的
 */

public class Parcel5 {
    public UserManager destionation(String str){
        class PDestionation implements UserManager{
            private String label;
            private PDestionation(String whereTo){
                label = whereTo;
            }
            public String readLabel(){
                return label;
            }
			@Override
			public void addUser(String id, String password) {
				// TODO Auto-generated method stub
				System.out.println(label);;
			}
			@Override
			public void delUser(String id) {
				// TODO Auto-generated method stub
				
			}
        }
        return new PDestionation(str);
    }
    
    public static void main(String[] args) {
        Parcel5 parcel5 = new Parcel5();
        UserManager d = parcel5.destionation("chenssy");
        d.addUser(null, null);

    }
}
