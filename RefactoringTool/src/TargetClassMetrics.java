
public class TargetClassMetrics {
	public String classname;
	private int static_called,static_created,static_accessed,static_returned,static_parameter,dynamic_called,dynamic_created,dynamic_accessed;

	public TargetClassMetrics(String name){

		classname = name;
		static_called = 0;
		static_created = 0;
		static_accessed = 0;
		static_returned = 0;
		static_parameter = 0;
		dynamic_called = 0;
		dynamic_created = 0;
		dynamic_accessed = 0;
	}
	
	public void setValue(int num,int kind){
		switch (kind){
		case 0:
			setStatic_called(num);
			break;
		case 1:
			setStatic_created(num);
			break;
		case 2:
			setStatic_accessed(num);
			break;
		case 3:
			setStatic_returned(num);
			break;
		case 4:
			setStatic_parameter(num);
			break;
		case 5:
			setDynamic_called(num);
			break;
		case 6:
			setDynamic_created(num);
			break;
		case 7:
			setDynamic_accessed(num);
			break;
		}
	}

	public int getTotalValue(){
		return static_called+static_created+static_accessed+static_returned+static_parameter+dynamic_called+dynamic_created+dynamic_accessed;
	}
	
  	public int getStatic_created() {
		return static_created;
	}
	public void setStatic_created(int static_created) {
		this.static_created = this.static_created + static_created;
	}

	public int getStatic_returned() {
		return static_returned;
	}
	public void setStatic_returned(int static_returned) {
		this.static_returned = this.static_returned + static_returned;
	}

	public int getDynamic_accessed() {
		return dynamic_accessed;
	}
	public void setDynamic_accessed(int dynamic_accessed) {
		this.dynamic_accessed = this.dynamic_accessed + dynamic_accessed;
	}

	public int getDynamic_created() {
		return dynamic_created;
	}
	public void setDynamic_created(int dynamic_created) {
		this.dynamic_created = this.dynamic_created + dynamic_created;
	}

	public int getStatic_called() {
		return static_called;
	}
	public void setStatic_called(int static_called) {
		this.static_called = this.static_called  + static_called;
	}

	public int getStatic_accessed() {
		return static_accessed;
	}
	public void setStatic_accessed(int static_accessed) {
		this.static_accessed = this.static_accessed  + static_accessed;
	}

	public int getDynamic_called() {
		return dynamic_called;
	}
	public void setDynamic_called(int dynamic_called) {
		this.dynamic_called = this.dynamic_called  + dynamic_called;
	}

	public int getStatic_parameter() {
		return static_parameter;
	}
	public void setStatic_parameter(int static_parameter) {
		this.static_parameter = this.static_parameter  + static_parameter;
	}

	public String returnLine(){
		return classname+","+static_called+","+static_created+","+static_accessed+","+static_returned+","+static_parameter+","+dynamic_called+","+dynamic_created+","+dynamic_accessed;
	}
	
	public String returnScore(){
		double score =((double)static_called+(double)static_created+(double)static_accessed+(double)static_returned+(double)static_parameter)/5+((double)dynamic_called+(double)dynamic_created+(double)dynamic_accessed)/3;
		return classname+":"+score;	
	}
	
	public Double getScore(){
		double score =((double)static_called+(double)static_created+(double)static_accessed+(double)static_returned+(double)static_parameter)/5+((double)dynamic_called+(double)dynamic_created+(double)dynamic_accessed)/3;
		return score;	
	}
}
