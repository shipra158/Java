package com.cg.employeemgt.entities;

public class Employee {
		
		private int id;
		private String name;
		private int score;
		public Employee(){
			this("not initialized",1);
		}
		
		
		public Employee(String name, int score){
			this.setName(name);
		    this.setScore(score);
		    
		}
		
	    public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id=id;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name=name;
		}
		
		public int getScore() {
			return score;
		}
		
		public void setScore(int score) {
			this.score=score;
		}

		@Override
		public String toString() {
			String text="id:"+id +" name-"+name+"-"+score;
		    return text;
		}


		@Override
		public int hashCode() {
			return id;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			 if(obj==null || !(obj instanceof Employee)) {
				 return false;
			 }
			 Employee that=(Employee)obj;
			return this.id==that.id;
		}	
}
