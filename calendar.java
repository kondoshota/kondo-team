import java.util.Calendar;

class calendar extends Executer {
    public void calendar(){
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd"+"("+"E"+")"+"HH:mm:ss");
        String dateStr = parser.format(date);
    }
}
