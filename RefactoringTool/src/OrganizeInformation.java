
public class OrganizeInformation {

		public static String[] SplitThree(String line){
			String tmp[] = new String[2];
			String data[] = new String[3];
			if(line.endsWith("\"")) line = line + ",1";
			tmp = line.split("\",\"",2);
			data[0]=tmp[0].substring(1);
			tmp = tmp[1].split("\",",2);
			data[1]=tmp[0];
			data[2]=tmp[1];
			return data;
		}
}
