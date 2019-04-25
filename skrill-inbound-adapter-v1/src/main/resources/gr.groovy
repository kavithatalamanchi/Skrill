import java.text.DateFormat
import java.text.SimpleDateFormat

class gr {
	
	static void main(String[] args) {
		Date localTime = new Date(); 
    
     //creating DateFormat for converting time from local timezone to GMT
     DateFormat converter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
    
     //getting GMT timezone, you can get any timezone e.g. UTC
     converter.setTimeZone(TimeZone.getTimeZone("GMT"));
    
     System.out.println("local time : " + localTime);;
     System.out.println("time in GMT : " + (converter.format(localTime)));
Date date2= (Date.parse("EEE, dd MMM yyyy HH:mm:ss","Thu, 26 Dec 2019 09:08:15"))

def nowDate = Date.parse("EEE, dd MMM yyyy HH:mm:ss", "Thu, 26 Dec 2019 09:54:20 GMT")

println Calendar.getInstance(TimeZone.getTimeZone('GMT')).format("EEE, dd MMM yyyy HH:mm:ss z")
SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
println sdf.format(sdf.parse("Thu, 26 Dec 2019 09:54:20 GMT"));
//print converter.format(nowDate)

SimpleDateFormat fr = new SimpleDateFormat(
	"yyyy-MM-dd'T'HH:mm:ss.SSS");
fr.setTimeZone(TimeZone.getTimeZone("UTC"));

println fr.format(fr.parse("2019-01-02T04:31:53.213"));

SimpleDateFormat fr1 = new SimpleDateFormat(
	"yyyyMMddHHmmssSSS");
fr1.setTimeZone(TimeZone.getTimeZone("UTC"));

println fr1.format(fr.parse("2019-01-02T04:31:53.213"));

	}
	

}
