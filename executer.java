class Executer {
	
	DBAccessor dba = null;
	
	public Executer(){
		try{
			dba = new DBAccessor();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
