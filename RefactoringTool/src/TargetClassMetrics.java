
public class TargetClassMetrics {
	public String classname;
	private int static_call,static_called,static_access,dynamic_called,dynamic_created,dynamic_accessed;

	public TargetClassMetrics(String name){

		classname = name;
		static_call = 0;
		static_called = 0;
		static_access = 0;
		dynamic_called = 0;
		dynamic_created = 0;
		dynamic_accessed = 0;
	}

	public void setValue(int num,int kind){
		switch (kind){
		case 0:
			setStatic_call(num);
			break;
		case 1:
			setStatic_called(num);
			break;
		case 2:
			setStatic_access(num);
			break;
		case 3:
			setDynamic_called(num);
			break;
		case 4:
			setDynamic_created(num);
			break;
		case 5:
			setDynamic_accessed(num);
			break;
		}
	}

	public int getTotalValue(){
		return static_called+static_call+static_access+dynamic_called+dynamic_created+dynamic_accessed;
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

	public int getStatic_call() {
		return static_call;
	}
	public void setStatic_call(int static_call) {
		this.static_call = this.static_call  + static_call;
	}

	public int getStatic_called() {
		return static_called;
	}
	public void setStatic_called(int static_called) {
		this.static_called = this.static_called  + static_called;
	}
	public int getStatic_access() {
		return static_access;
	}
	public void setStatic_access(int static_access) {
		this.static_access = this.static_access  + static_access;
	}

	public int getDynamic_called() {
		return dynamic_called;
	}
	public void setDynamic_called(int dynamic_called) {
		this.dynamic_called = this.dynamic_called  + dynamic_called;
	}

	public String returnLine(){
		return classname+","+static_call+","+static_called+","+static_access+","+dynamic_called+","+dynamic_created+","+dynamic_accessed;
	}

	public String returnScore(){
		double score = getScore();
		return classname+":"+ score;
	}

	public Double getScore(){
		double score =((double)static_call+(double)static_called+(double)static_access*2)/4+((double)dynamic_called+(double)dynamic_created+(double)dynamic_accessed)/3;
		return score;
	}
}
