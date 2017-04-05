package src.main.java.edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.plaf.basic.BasicLabelUI;


public class LambdaScheduler {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Job> jobs = new ArrayList<>();
		jobs.add( new Job(1, 5, 0));
		jobs.add( new Job(6, 11, 0));
		jobs.add( new Job(12, 17, 0));
		jobs.add( new Job(18, 22, 0));
		jobs.add( new Job(2, 8, 0));
		jobs.add( new Job(3, 9, 0));
		jobs.add( new Job(4, 7, 0));
		jobs.add( new Job(10, 13, 0));
		jobs.add( new Job(14, 20, 0));
		jobs.add( new Job(15, 19, 0));
		jobs.add( new Job(16, 20, 0));
		List<Job> result = schedule(jobs);
		System.out.println(result);
	}
	
	public static List<Job> schedule(List<Job> jobList ){
		List<Job> result = new ArrayList<>(); 
		Set<List<Job>> arranged = new TreeSet<>(new Comparator<List<Job>>() {

			@Override
			public int compare(List<Job> o1, List<Job> o2) {
				return o2.size() - o1.size();
			}
			
		}); 
		
		jobList.sort(new Comparator<Job>() {

			@Override
			public int compare(Job o1, Job o2) {
				if(o1._s_ != o2._s_)
					return (int) (o1._s_ - o2._s_);
				return (int) (o1._t_ - o2._t_);
			}
		});
		
		for(int index = jobList.size() - 1; index > -1; index--){
			Job job = jobList.get(index);
			Iterator<List<Job>> iterator = arranged.iterator();
			boolean flag = false;
			while(iterator.hasNext()){
				List<Job> cur = iterator.next();
				if(cur.get(0)._s_ >= job._t_ ){
					cur.add(0, job);
					flag = true;
					if(result == null || cur.size() > result.size())
						result = cur;
				}
			}
			if(!flag){
				List<Job> temp = new ArrayList<>();
				temp.add(job);
				arranged.add(temp);
			}
		}
		
		return result;
	}
	
	
}


