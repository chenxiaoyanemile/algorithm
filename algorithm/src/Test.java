

public class Test {
	
	public static void main(String args[]) {
		String mes = "@SIC,,SET,DEVICE.SIC_VERSION,SIC_2.0,OK,#bb";
		String mes2= "$PSIC,AAT,3,-88";
		int res = mes.compareTo("@SIC,,SET,DEVICE.SIC_VERSION,SIC_2.0,OK,");
		
		 String str = "@SIC,,SET,DEVICE.SIC_VERSION,SIC_2.0,OK";
		 
		 Kmp(mes,str,0);
		 System.out.print("kmp"+Kmp(mes,str,0)+"\n");
		 System.out.print("kmp"+Kmp(mes2,str,0)+"\n");
		 
		 String[] strs=str.split(",");
		 for(int i=0,len=strs.length;i<len;i++){
		    
		     if(strs[i].toString().equals("OK")) {
		    	 System.out.print(strs[i].toString()+" "+i);
		     }
		 } 
		 
	}
	

	public static int Kmp(String str,String sub,int pos){
		int i = pos;
		int j = 0;
		int[] next = new int[sub.length()];
		getNext(next,sub);
		while(i < str.length() && j < sub.length()){
			if(j == -1 || str.charAt(i) == sub.charAt(j)){
				i++;
				j++;
			}else{
				j = next[j];
			}
		}
		if(j >= sub.length()){
			return i-j;
		}else{
			return -1;
		}
	}
	

	public static void getNext(int[] next,String str){
		next[0] = -1;
		next[1] = 0;
		int i = 2;//下一项
		int k = 0;//前一项的k
		while(i < str.length()){
			if(k == -1||str.charAt(k) == str.charAt(i - 1)){//Pk == Pi时
				next[i] = k + 1;
				i++;
				k = k+1;
			}else{
				k = next[k];
			}
		}
	}


}
