package ATM;

import java.util.Scanner;

public class Method {
    static Scanner sc=new Scanner(System.in);
    static String[] name=new String[10];
    static String[] id=new String[10];
    static String[] pwd=new String[10];
    static int count=0;
    static int k=0;
    static int l=0;
    static int p=1;
    public static String number,pwdd,sex;
    public static float money=0;
    public static void jieMian()
    {
        System.out.println("--------------------");
        System.out.println("------1.注册------");
        System.out.println("------2.登录------");
        System.out.println("-----3.退出系统-----");

    }
    //菜单
    public static void menu()
    {
        System.out.println("请输入操作序号1/2/3：");
        int i=sc.nextInt();
        switch(i)
        {
            case 1:
                //注册
                zhuCe();
                break;
            case 2:
                dengLu();
                //登录
                break;

            case 3:
                exit();
                //退出
                break;
            default:
                System.out.println("输入错误，请重新选择！");
                menu();

        }
    }
    public static void menu_gongNeng()
    {
        System.out.println("  ****************   ");
        System.out.println("   1.存款");
        System.out.println("   2.取款");
        System.out.println("   3.查看余额");
        System.out.println("   4.查看个人信息");
        System.out.println("   5.修改密码");
        System.out.println("   6.注销登录");
        System.out.println("   7.退出系统");
        System.out.println("  ****************   ");
        System.out.println("请选择菜单：");
        int a;
        a=sc.nextInt();
        menu_choose(a);
    }

    public static void allUsers()
    {
        int i=1;
        String y="";
        int j=0;
        for(String x:name)
        {
            if(x==null) break;
            System.out.println("这是第"+i+"位用户:");
            System.out.print("用户名:");
            System.out.print(x);
            for(j=i-1;j<count;j++)
            {
                y=id[j];
                do {
                    if(y==null)break;
                    System.out.print("  账号:");
                    System.out.println(y);
                    y=null;
                }while(true);
                i++;
                break;

            }
        }
    }
    public static void menu_choose(int i)
    {
        switch(i)
        {
            case 1:
                System.out.println("存款。。。");
                addMon();
                break;
            case 2:
                System.out.println("取款。。。");
                get_mon();
                break;
            case 3:
                System.out.println("查看余额。。。");
                System.out.println("当前余额为:"+money);
                menu_gongNeng();
                break;
            case 4:
                System.out.println("查看个人信息。。。");
                allUsers();
                menu_gongNeng();
                break;
            case 5:
                System.out.println("修改密码。。。");
                alter();
                menu_gongNeng();
                break;
            case 6:
                System.out.println("注销登录。。。");
                zhuXiao();
                zhuCe();
                menu_gongNeng();
                break;
            case 7:
                System.out.println("退出系统。。。");
                exit();
                break;
        }
    }

    public static void zhuXiao()
    {
        count--;
        System.out.println("已注销！请重新注册！");
    }
    public static void alter()
    {
        System.out.println("请输入用户名进行验证：");
        String str=sc.next();//count==0
        do {
            if(!name[l].equals(str))
            {
                if((l+1)==count)
                {
                    System.out.println("用户不存在!请先进行注册！");
                    break;
                }
                else
                {
                    l++;
                    continue;
                }

            }
            else
            {
                System.out.println("用户名验证成功！请进行下一步");
                miMaYan();
                yanZheng();
            }
        }while (true);

        zhuCe();
    }

    public static void miMaYan()
    {

        do
        {
            System.out.println("请输入密码进行验证：");
            String pwdd=sc.next();
            if(pwd[l].equals(pwdd))
            {
                break;
            }
            else {
                if(p==3)
                {
                    System.out.println("密码错误次数过多！即将退出到登录界面！");
                    dengLu();
                    break;
                }
                else
                {System.out.println("密码不匹配！请重新输入：");
                    p++;
                    miMaYan();

                }

            }
        }while (true);
    }
    public static void yanZheng()
    {

        do {
            System.out.println("请输入原始密码：");
            String num3=sc.next();
            if(num3.equalsIgnoreCase(pwd[l]))
            {
                System.out.println("请输入新密码：");
                pwd[l]=sc.next();
                System.out.println("修改成功！请重新登录！");
                dengLu();
            }
            else
            {
                System.out.println("原始密码输入错误！请重新输入！");
                yanZheng();
            }

        }while (true);

    }


    public  static void zhuCe()
    {

        do {
            if(count>=10)
            {
                System.out.println("已超出限制人数,请联系管理员处理，即将退出系统!");
                exit();
            }
            System.out.println("这是第"+(count+1)+"用户注册！");
            yongHu();
            zhangHao();
            System.out.println("请输入密码：");
            pwd[count]=sc.next();
            System.out.println("注册成功！");
            count++;
            jieMian();
            menu();



        }while(true);


    }

    //账号输入
    public static void zhangHao()
    {
        System.out.println("请输入账号：");
        String y=id[count]=sc.next();
        for(int i=0;i<count;i++)
        {
            if(y.equals(id[i]))
            {
                System.out.println("账号已重复，请重新输入：");
                zhangHao();
            }
            else
            {
                break;
            }
        }
    }
    //用户输入用户名
    public static void yongHu()
    {
        System.out.println("请输入用户名：");
        String x=name[count]=sc.next();
        //判断用户名是否合法
        for(int i=0;i<count;i++)
        {
            if(x.equals(name[i]))
            {
                System.out.println("用户名已重复，请重新输入：");
                yongHu();
            }
            else
            {
                break;
            }
        }
    }

    public static void dengLu()
    {
        int a=0;
        do {
            System.out.println("请输入用户名：");
            String name1=sc.next();
            //下面这个是错的，第二名及以后的用户不可以登录
            /*for(int i=0;i<=count;i++)
            {
                if(name1.equals(name[i]))
                {
                    k=i;
                    miMa(k);
                    jieMian();
                    menu();
                }
                else
                {
                    System.out.println("用户名不存在！请先进行注册！");
                    jieMian();
                    menu();
                }
            }*/
            do {
                if(a>count)
                {
                    System.out.println("用户名不存在！请先注册！");
                    jieMian();
                    menu();
                    break;
                }
                if(name1.equals(name[a]))
                {
                    k=a;
                    miMa(k);
                    jieMian();
                    menu();
                }
                else
                {
                    a++;
                }

            }while(true);
        }while(true);
    }
    //登录密码输入
    public static void miMa(int x)
    {
        System.out.println("请输入密码：");
        String pwdd=sc.next();
        if(pwdd.equals(pwd[x]))
        {
            System.out.println("登录成功！");
            menu_gongNeng();
        }
        else
        {
            System.out.println("密码输入错误！请重新输入：");
            miMa(x);
        }
    }
    public static void addMon()
    {
        do {
            System.out.println("请输入存款金额：");
            float mon1=sc.nextFloat();
            money+=mon1;
            System.out.println("是否继续存款？N(不存)/Y(存)");
            String str=sc.next();
            if(str.equalsIgnoreCase("Y"))
                continue;
            else
            {
                break;
            }
        }while(true);
        System.out.println("账户余额为："+money);
        menu_gongNeng();
    }
    public static void get_mon()
    {
        do {
            if(money==0)
            {
                System.out.println("您当前余额为0！请先去挣钱吧！");
                menu_gongNeng();
            }
            System.out.println("请输入取款金额：");
            float mon2=sc.nextFloat();
            while (true)
            {
                if (mon2 > money) {
                    System.out.println("余额不足！请重新输入：");
                    mon2 = sc.nextFloat();
                } else {
                    money -= mon2;
                    break;
                }
            }
            System.out.println("已取"+mon2+"元！"+" "+"当前剩余余额为："+money+"元！");
            System.out.println("是否继续取钱？N(不取)/Y(取)");
            String str1=sc.next();
            if(str1.equalsIgnoreCase("Y"))
                continue;
            else

                break;


        }while(true);
        menu_gongNeng();
    }
    public static void exit()
    {
        System.out.println("已退出系统!");
        System.exit(0);
    }

}
