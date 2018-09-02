import com.jcraft.jsch.*;
import com.lsl.utils.JsonUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {
    public static void main(String[] args) throws ParseException {
        String date="2001-08-01 22:22:22";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = simpleDateFormat.parse(date);
        String s = JsonUtil.objectToJson(parse);
        System.out.println(s);
    }

    public static void test1(){
        JSch jSch = new JSch();
        Session session=null;
        Channel channel=null;
        try {
            String result=null;
            session = jSch.getSession("root", "192.168.25.133", 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword("070800");
            session.connect();
            channel= session.openChannel("exec");
            ((ChannelExec)channel).setCommand("cd /backup&&mkdir test");
            channel.connect();

        } catch (JSchException e) {
            e.printStackTrace();
        }if (channel!=null&&!channel.isClosed()){
            channel.disconnect();
        }
        if (session!=null&&session.isConnected()){
            session.disconnect();
        }
    }

    @org.junit.Test
    public void test3() throws ParseException {
        String time = "2018-07-01 00:00:00";
        SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        System.out.println(format.parse(time));
    }

    @org.junit.Test
    public void test4(){
        String time = "1,2,3,4,";
        String[] split = time.split(",");
        System.out.println(split.length);
        System.out.println(split);
    }

    @org.junit.Test
    public void  test5(){
        String PHYSICAL_BACKUP_PATH = "/backup/backupshell/physicalbackup.sh";
        String[] days= "1,2,3,4,".split(",");
        String hour = "5";
        String minute = "03";
        String fullDays  = "";
        for (int i = 0; i < days.length; i++) {
            String tmp = days[i];
            if (i != days.length-1)
                fullDays+=tmp+",";
            else
                fullDays+=tmp+" ";
        }
        String command = "echo \""+minute+" "+hour+" * * "+fullDays+" root "+PHYSICAL_BACKUP_PATH +" "+"root"
                +" "+"070800"+"\" >> /etc/crontab&&service crond restart";
        System.out.println(command);
    }
}
