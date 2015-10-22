import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class InputFiles {

	public static final int FILE_NUMBER = 6;

	public static void main(String[] args) {
		TreeMap<String,TargetClassMetrics> map = new TreeMap<String,TargetClassMetrics>();
		String[] file_name = new String[FILE_NUMBER];
		file_name[0] = "C:\\Users\\naoya-u\\GoogleDrive\\study\\soba_output\\OutputStaticMetrics\\call.txt";
		file_name[1] = "C:\\Users\\naoya-u\\GoogleDrive\\study\\soba_output\\OutputStaticMetrics\\called.txt";
		file_name[2] = "C:\\Users\\naoya-u\\GoogleDrive\\study\\soba_output\\OutputStaticMetrics\\access.txt";
//		file_name[0] = "C:\\Users\\naoya-u\\GoogleDrive\\study\\soba_output\\jfreechart-1.0.9\\static_method_calls.txt";
//		file_name[1] = "C:\\Users\\naoya-u\\GoogleDrive\\study\\soba_output\\jfreechart-1.0.9\\static_object_instantiations.txt";
//		file_name[2] = "C:\\Users\\naoya-u\\GoogleDrive\\study\\soba_output\\jfreechart-1.0.9\\static_field_accesses.txt";
//		file_name[3] = "C:\\Users\\naoya-u\\GoogleDrive\\study\\soba_output\\jfreechart-1.0.9\\static_return_type.txt";
//		file_name[4] = "C:\\Users\\naoya-u\\GoogleDrive\\study\\soba_output\\jfreechart-1.0.9\\static_parameter_types.txt";
		file_name[3] = "C:\\Users\\naoya-u\\GoogleDrive\\study\\selogger-master\\trunk\\doc\\dynamic_method_calls3.txt";
		file_name[4] = "C:\\Users\\naoya-u\\GoogleDrive\\study\\selogger-master\\trunk\\doc\\dynamic_object_instantiations3.txt";
		file_name[5] = "C:\\Users\\naoya-u\\GoogleDrive\\study\\selogger-master\\trunk\\doc\\dynamic_field_accesses3.txt";
		for(int i=0;i<FILE_NUMBER;i++){
		try{
		      File file = new File(file_name[i]);

		      if (checkBeforeReadfile(file)){
		        BufferedReader br = new BufferedReader(new FileReader(file));

		        String str;
		        while((str = br.readLine()) != null){
		          TargetClassMetrics metrics;
		          String data[] = OrganizeInformation.SplitThree(str);
		          data[1] = deleteArray(data[1]);
		          if(!isPrimitive(data[1])){
		          if(map.containsKey(data[0]+"->"+data[1])){
		        	  metrics = map.get(data[0]+"->"+data[1]);
		          }else{
		        	metrics = new TargetClassMetrics(data[1]);
		          }
					metrics.setValue(Integer.parseInt(data[2]),i);
					map.put(data[0]+"->"+data[1], metrics);
		          }
		        }

		        br.close();
		      }else{
		        System.out.println("�t�@�C����������Ȃ����J���܂���");
		      }
		    }catch(FileNotFoundException e){
		      System.out.println(e);
		    }catch(IOException e){
		      System.out.println(e);
		    }
		}

		 String before_method_name="";
		 ArrayList<Double> scoreList =  new ArrayList<Double>();
		 ArrayList<String> nameList =  new ArrayList<String>();
		 //���̒��͊e���\�b�h��
         for(Map.Entry<String,TargetClassMetrics> metri:map.entrySet()){
        	String method_name = metri.getKey().substring(0,metri.getKey().indexOf("-"));
       	  	if(before_method_name!="" && !before_method_name.equals(method_name)){
       	  		if(!map.containsKey(before_method_name+"->"+before_method_name.split("#")[0])){
             		  scoreList.add(0,(double)0);
               		  nameList.add(0,before_method_name.split("#")[0]);
       	  		}
       	  		System.out.println(before_method_name);
           	  	for(int i=scoreList.size()-1;i>-1;i--){
           	  		System.out.println(nameList.get(i)+" : "+scoreList.get(i));
           	  	}
           	  	System.out.println();
           	  	scoreList.clear();
           	  	nameList.clear();
       	  	}
       	  	before_method_name = method_name;

//       	  if(metri.getValue().getTotalValue()!=0)
//       		  System.out.println(metri.getValue().returnLine());


       	  	if(scoreList.isEmpty() || scoreList.get(scoreList.size()-1) < metri.getValue().getScore()){
       		  scoreList.add(metri.getValue().getScore());
       		  nameList.add(metri.getValue().classname);
       	  	}else{
       	  		for(int i=0;i<scoreList.size();i++){
       	  			if(scoreList.get(i) >= metri.getValue().getScore()){
       	  				scoreList.add(i,metri.getValue().getScore());
       	  				nameList.add(i,metri.getValue().classname);
       				  break;
       			  }
       	  		}
       	  	}
         }
	}

	  private static boolean checkBeforeReadfile(File file){
		    if (file.exists()){
		      if (file.isFile() && file.canRead()){
		        return true;
		      }
		    }

		    return false;
	  }

	  private static boolean isPrimitive(String str){
		  String[] pri_arr = {"int","void","long","short","boolean","double","byte","float","java/lang/String"};
		  for(String pri:pri_arr){
			  if(str.equals(pri)) return true;
		  }
		  return false;
	  }

	  private static String deleteArray(String str){
		  while(str.contains("[]")){
			  str = str.substring(0,str.length()-2);
		  }
		  return str;
	  }
}
