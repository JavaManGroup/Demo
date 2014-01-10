import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		String s = "a___10239b___guoc___11d___Fe___广东f___珠海g___大连h___.jpg";
		Map userInfo = getUserInfo(s);
		System.out.println(userInfo);
		
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
		Matcher matcher = pattern.matcher("a@aa.com");
		
		System.out.println(matcher.matches());
		Rectangle r =new Rectangle();
		Image m = new Image() {
			
			@Override
			public int getWidth(ImageObserver observer) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public ImageProducer getSource() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getProperty(String name, ImageObserver observer) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getHeight(ImageObserver observer) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Graphics getGraphics() {
				// TODO Auto-generated method stub
				return null;
			}
		};

	}

	public static Map getUserInfo(String s) {
		int b_s = s.indexOf("b___");
		int b_e = s.indexOf("c___");
		int c_s = s.indexOf("c___");
		int c_e = s.indexOf("d___");
		int d_s = s.indexOf("d___");
		int d_e = s.indexOf("e___");
		int e_s = s.indexOf("e___");
		int e_e = s.indexOf("f___");
		int f_s = s.indexOf("f___");
		int f_e = s.indexOf("g___");
		int g_s = s.indexOf("g___");
		int g_e = s.indexOf("h___");
		Map map = new HashMap();
		System.out.println();
		String uuid = s.substring(4, 9);
		System.out.println();
		String nick = s.substring(b_s + 4, b_e);
		System.out.println();
		String age = s.substring(c_s + 4, c_e);
		System.out.println();
		String sex = s.substring(d_s + 4, d_e);
		System.out.println();
		String city = s.substring(e_s + 4, e_e);
		System.out.println();
		String local = s.substring(f_s + 4, f_e);
		System.out.println();
		String des = s.substring(g_s + 4, g_e);
		
		map.put("UUID", Integer.valueOf(uuid));
		map.put("NICK", nick);
		map.put("SEX", sex);
		map.put("AGE", Integer.valueOf(age));
		map.put("CITY", city);
		map.put("LOCAL", local);
		map.put("DES", des);
		return map;
	}
	public static Map getCreateUserInfo(String s) {
		int a_s = s.indexOf("a_");
		int a_e = s.indexOf("b_");
		int b_s = s.indexOf("b_");
		int b_e = s.indexOf("c_");
		int c_s = s.indexOf("c_");
		int c_e = s.indexOf("d_");
		int d_s = s.indexOf("d_");
		int d_e = s.indexOf("e_");
		int f_e = s.indexOf("f_");
		System.out.println();
		String email =  s.substring(a_s + 2, a_e);
		System.out.println();
		String pass = s.substring(b_s + 2, b_e);
		System.out.println();
		String nick = s.substring(c_s + 2, c_e);
		System.out.println();
		String city = s.substring(d_s + 2, d_e);
		
		String sex = s.substring(d_e + 2 ,f_e);
		Map map = new HashMap();
		map.put("EMAIL", email);
		map.put("PASS", pass);
		map.put("NICK", nick);
		map.put("AGE", city);
		map.put("SEX", sex);
		return map;
	}
}
