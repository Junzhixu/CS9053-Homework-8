package src.main.java.edu.nyu.cs9053.homework8;

class Job{
	public double _s_;
	public double _t_;
	public int weight;
	
	Job(double s, double t, int w){
		_s_ = s;
		_t_ = t;
		weight = w;
	}
	
	@Override
	public String toString(){
		return "start:" + _s_ + " end:" + _t_ +  "weight:" + weight;
	}
}