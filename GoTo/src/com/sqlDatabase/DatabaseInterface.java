package com.sqlDatabase;

import goToPackage.Direction;

import java.util.ArrayList;

import jim.h.common.android.lib.zxing.sample.R;
import main.MainActivity;

public class DatabaseInterface {
	
	public TestAdapter mDbHelper;
	
	private String destination = "";
	private String beginning = "";
	//private ArrayList<String> images;

	public DatabaseInterface() {
		// TODO Auto-generated constructor stub
	}
	
	public DatabaseInterface(String destination, String beginning) {

		this.destination = destination;
		this.beginning = beginning;
		
	}
	
public ArrayList<Direction> getBuildingDirections() {
	
		String id = "";
		Direction dir = null;
		String direct="";
		String img="";
		//comment
		
		ArrayList<Direction> directions = new ArrayList<Direction>();
		
		try{
		
			mDbHelper.open();
		
			if(beginning.equalsIgnoreCase("GRUMBACHER ISTC")) {
		
				if(destination.equalsIgnoreCase("JRR STUDENT COMM. CNTR")){
			
			id = "11";
			
			for(int i=1; i<=4; i++){
								
				
				direct=mDbHelper.getData("Direction", "d00"+i, "directions");
				img=mDbHelper.getData("Direction", "d00"+i, "image_name");
				
				dir = new Direction(id, direct, img);
				directions.add(dir); 
				
				
				//images.add(img);
				
			} 
		
		}
				if(destination.equalsIgnoreCase("Elias (Science Building)")){
					
					id = "12";
					
					
					for(int i=5; i<=11; i++){
													
						
						if(i<=9){
						direct=mDbHelper.getData("Direction", "d00"+i, "directions");
						img=mDbHelper.getData("Direction", "d00"+i, "image_name");
						
						}
						
						else{
							direct=mDbHelper.getData("Direction", "d0"+i, "directions");
							img=mDbHelper.getData("Direction", "d0"+i, "image_name");
						
						}
						
						dir = new Direction(id, direct, img);
						directions.add(dir); 
						
						//images.add(img);
						
					} 
				
				}
				
				if(destination.equalsIgnoreCase("MCB/RAB")){
					
					id = "13";
					
					for(int i=12; i<=19; i++){
										
						
						direct=mDbHelper.getData("Direction", "d0"+i, "directions");
						img=mDbHelper.getData("Direction", "d0"+i, "image_name");
						dir = new Direction(id, direct, img);
						directions.add(dir); 
						
						
						//images.add(img);
					} 
				
				}
				
				if(destination.equalsIgnoreCase("Pullo Building (PAC)")){
					
					id = "14";
					
					for(int i=20; i<=26; i++){
										
						
						direct=mDbHelper.getData("Direction", "d0"+i, "directions");
						img=mDbHelper.getData("Direction", "d0"+i, "image_name");
						dir = new Direction(id, direct, img);
						directions.add(dir); 
						
						
						//images.add(img);
					} 
				}
			}
			
			
			else if(beginning.equalsIgnoreCase("Elias (Science Building)")) {
				
				if(destination.equalsIgnoreCase("GRUMBACHER ISTC")){
			
			id = "21";
			
			for(int i=27; i<=32; i++){
								
				
				direct=mDbHelper.getData("Direction", "d0"+i, "directions");
				img=mDbHelper.getData("Direction", "d0"+i, "image_name");
				dir = new Direction(id, direct, img);
				directions.add(dir); 
				
				
				//images.add(img);
			} 
		
		}
				else if(destination.equalsIgnoreCase("JRR STUDENT COMM. CNTR")){
					
					id = "22";
					
					
					for(int i=33; i<=38; i++){
													
						
						
						direct=mDbHelper.getData("Direction", "d0"+i, "directions");
						img=mDbHelper.getData("Direction", "d0"+i, "image_name");
						dir = new Direction(id, direct, img);
						directions.add(dir); 
						
						
						//images.add(img);
					} 
				
				}
				
				if(destination.equalsIgnoreCase("Pullo Building (PAC)")){
					
					id = "23";
					
					for(int i=39; i<=43; i++){
										
						
						direct=mDbHelper.getData("Direction", "d0"+i, "directions");
						img=mDbHelper.getData("Direction", "d0"+i, "image_name");
						dir = new Direction(id, direct, img);
						directions.add(dir); 
						
						
						//images.add(img);
					} 
				
				}
				
				if(destination.equalsIgnoreCase("MCB/RAB")){
					
					id = "24";
					
					for(int i=44; i<=49; i++){
										
						
						direct=mDbHelper.getData("Direction", "d0"+i, "directions");
						img=mDbHelper.getData("Direction", "d0"+i, "image_name");
						dir = new Direction(id, direct, img);
						directions.add(dir); 
						
						
						//images.add(img);
					} 
				}
			}
			
			
			else if(beginning.equalsIgnoreCase("JRR STUDENT COMM. CNTR")) {
				
				if(destination.equalsIgnoreCase("GRUMBACHER ISTC")){
			
			id = "31";
			
			for(int i=50; i<=53; i++){
								
				
				direct=mDbHelper.getData("Direction", "d0"+i, "directions");
				img=mDbHelper.getData("Direction", "d0"+i, "image_name");
				dir = new Direction(id, direct, img);
				directions.add(dir); 
				
				
				//images.add(img);
			} 
		
		}
				 if(destination.equalsIgnoreCase("Elias (Science Building)")){
					
					id = "32";
					
					
					for(int i=54; i<=58; i++){
													
						
						
						direct=mDbHelper.getData("Direction", "d0"+i, "directions");
						img=mDbHelper.getData("Direction", "d0"+i, "image_name");
						dir = new Direction(id, direct, img);
						directions.add(dir); 
						
						
						//images.add(img);
					} 
				
				}
				
				if(destination.equalsIgnoreCase("Pullo Building (PAC)")){
					
					id = "33";
					
					for(int i=64; i<=68; i++){
										
						
						direct=mDbHelper.getData("Direction", "d0"+i, "directions");
						img=mDbHelper.getData("Direction", "d0"+i, "image_name");
						dir = new Direction(id, direct, img);
						directions.add(dir); 
						
						
						//images.add(img);
					} 
				
				}
				
				if(destination.equalsIgnoreCase("MCB/RAB")){
					
					id = "34";
					
					for(int i=59; i<=63; i++){
										
						
						direct=mDbHelper.getData("Direction", "d0"+i, "directions");
						img=mDbHelper.getData("Direction", "d0"+i, "image_name");
						dir = new Direction(id, direct, img);
						directions.add(dir); 
						
						
						//images.add(img);
					} 
				}
			}
			
else if(beginning.equalsIgnoreCase("MCB/RAB")) {
				
				if(destination.equalsIgnoreCase("GRUMBACHER ISTC")){
			
			id = "41";
			
			for(int i=69; i<=74; i++){
								
				
				direct=mDbHelper.getData("Direction", "d0"+i, "directions");
				img=mDbHelper.getData("Direction", "d0"+i, "image_name");
				dir = new Direction(id, direct, img);
				directions.add(dir); 
				
				
				//images.add(img);
			} 
		
		}
				else if(destination.equalsIgnoreCase("Elias (Science Building)")){
					
					id = "42";
					
					
					for(int i=84; i<=88; i++){
													
						
						
						direct=mDbHelper.getData("Direction", "d0"+i, "directions");
						img=mDbHelper.getData("Direction", "d0"+i, "image_name");
						dir = new Direction(id, direct, img);
						directions.add(dir); 
						
						
						//images.add(img);
					} 
				
				}
				
				if(destination.equalsIgnoreCase("Pullo Building (PAC)")){
					
					id = "43";
					
					for(int i=75; i<=77; i++){
										
						
						direct=mDbHelper.getData("Direction", "d0"+i, "directions");
						img=mDbHelper.getData("Direction", "d0"+i, "image_name");
						dir = new Direction(id, direct, img);
						directions.add(dir); 
						
						
						//images.add(img);
					} 
				
				}
				
				if(destination.equalsIgnoreCase("JRR STUDENT COMM. CNTR")){
					
					id = "44";
					
					for(int i=78; i<=83; i++){
										
						
						direct=mDbHelper.getData("Direction", "d0"+i, "directions");
						img=mDbHelper.getData("Direction", "d0"+i, "image_name");
						dir = new Direction(id, direct, img);
						directions.add(dir); 
						
						
						//images.add(img);
					} 
				}
			}
			
			
else if(beginning.equalsIgnoreCase("Pullo Building (PAC)")) {
	
	if(destination.equalsIgnoreCase("MCB/RAB")){

id = "51";

for(int i=89; i<=92; i++){
					
	
	direct=mDbHelper.getData("Direction", "d0"+i, "directions");
	img=mDbHelper.getData("Direction", "d0"+i, "image_name");
	dir = new Direction(id, direct, img);
	directions.add(dir); 
	
	
	//images.add(img);
} 

}
	else if(destination.equalsIgnoreCase("Elias (Science Building)")){
		
		id = "52";
		
		
		for(int i=93; i<=98; i++){
										
			
			
			direct=mDbHelper.getData("Direction", "d0"+i, "directions");
			img=mDbHelper.getData("Direction", "d0"+i, "image_name");
			dir = new Direction(id, direct, img);
			directions.add(dir); 
			
			
			//images.add(img);
		} 
	
	}
	
	if(destination.equalsIgnoreCase("JRR STUDENT COMM. CNTR")){
		
		id = "53";
		
		for(int i=99; i<=104; i++){
							
			if(i==99){
			direct=mDbHelper.getData("Direction", "d0"+i, "directions");
			img=mDbHelper.getData("Direction", "d0"+i, "image_name");
			
			}
			else{
				direct=mDbHelper.getData("Direction", "d"+i, "directions");
				img=mDbHelper.getData("Direction", "d"+i, "image_name");
				
			}
			dir = new Direction(id, direct, img);
			directions.add(dir); 
			
			//images.add(img);
		} 
	
	}
	
	if(destination.equalsIgnoreCase("GRUMBACHER ISTC")){
		
		id = "54";
		
		for(int i=105; i<=111; i++){
							
			
			direct=mDbHelper.getData("Direction", "d"+i, "directions");
			img=mDbHelper.getData("Direction", "d"+i, "image_name");
			dir = new Direction(id, direct, img);
			directions.add(dir); 
			
			
			//images.add(img);
		} 
	}
}
			
		}
				
			
		finally{
		
			
		
		}
				
		mDbHelper.close();		
		
		return directions;
		
	}

/*
public void setImageArray(ArrayList<String> img){
	images=img;
	
}

public ArrayList<String> getImageArray(){
	return images;
}

*/


public void setDatabase(TestAdapter abc ){
	
	mDbHelper=abc;
	
}


}
