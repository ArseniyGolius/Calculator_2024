import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sb = new Scanner(System.in);
        String g = sb.nextLine();
        test(g);
    }

    public static void test(String h) {
        StringBuffer r = new StringBuffer();
        StringBuffer o = new StringBuffer();
        char l = 0;
        int a = 0;
        for (int i = 0; i < h.length(); i++) {
            if (h.charAt(i) == '\"') {
                if (a > 1) {
                    o.append(h.charAt(i));
                } else {
                    a += 1;
                    r.append(h.charAt(i));
                }
            } else if (a <= 1) {
                r.append(h.charAt(i));
            } else {
                if (h.charAt(i) == '+' || h.charAt(i) == '-' ||
                        h.charAt(i) == '/' || h.charAt(i) == '*') {
                    l = h.charAt(i);
                } else if (h.charAt(i) == ' ') ;
                else {
                    o.append(h.charAt(i));
                }
            }
        }
        job_4(r, o, l);


    }

    public static void job(StringBuffer a, StringBuffer b, char c) {
        String t = "";
        String q = String.valueOf(a);
        String w = String.valueOf(b);
        var e = "\"\"";
        var y = "\"";
        if (c == '+') {
            t = q.concat(w).replaceAll(e, "");
            job_3(t);
        } else if (c == '-') {
            t = q.concat(w);
            if (t.contains(w) == true) {
                w = w.replaceAll(y, "");
                q = q.replaceAll(w, "");
                job_3(q);
            }
        } else if (c == '*') {
            int o = Integer.parseInt(w);
            for (int i = 0; i < o; i++) {
                t = t.concat(q).replaceAll(e, "");
            }
            job_3(t);
        } else if (c == '/') {
            int sum = 0;
            int o = Integer.parseInt(w);
            q = q.replaceAll(y, "");
            int jk = q.length();
            sum = jk / o;
            q = q.substring(0, sum);
            job_3(q);
        }

    }

    public static void job_3(String a) {
        if (a.length() > 42) {
          StringBuffer b = new StringBuffer(a);
          System.out.println(b.replace(a.lastIndexOf("\""),a.lastIndexOf("\"") +1,"...\""));
        } else {
            System.out.println(a);
        }

    }

    public static void job_4(StringBuffer a, StringBuffer b, char c)  {
        String r = String.valueOf(b);
        String q = String.valueOf(a);
        int bv = 0;
        for (int i=0;i<q.length();i++){
            if(Character.isDigit(q.charAt(i))){
                bv+=1;
            }
            if (bv==r.length()){
                System.out.println("Нельзя вводить число первым значением");
            }
        }


        try {
            int y = Integer.parseInt(r);
            if (a.length() <= 12 || y < 12) {
                job(a, b, c);
            } else {
                System.out.println("Строка должна быть не более 10 симвлов, число от 1 до 10");
            }
        } catch (NumberFormatException u){
            if (a.length() <= 12 && b.length() <= 12) {
                job(a, b, c);
            } else {
                System.out.println("Первая или вторая строка имеют более 10 символов");
            }
        }

    }
}
