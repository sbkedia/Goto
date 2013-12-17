package main;

import java.util.ArrayList;

import jim.h.common.android.lib.zxing.config.ZXingLibConfig;
import jim.h.common.android.lib.zxing.integrator.IntentIntegrator;
import jim.h.common.android.lib.zxing.integrator.IntentResult;
import jim.h.common.android.lib.zxing.sample.R;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.sqlDatabase.DatabaseInterface;
import com.sqlDatabase.TestAdapter;

import goToPackage.*;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
//import android.text.SpannableString;
//import android.text.style.ImageSpan;
//import android.graphics.LightingColorFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
//import android.widget.Button;
import android.widget.TextView;

public class GetDirections extends Activity {
	
	private Handler        handler = new Handler();
    //private TextView       txtScanResult;
    private ZXingLibConfig zxingLibConfig;
    
    private String scanResultTxt;

    public static TestAdapter mDbHelper;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_directions);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		zxingLibConfig = new ZXingLibConfig();
        zxingLibConfig.useFrontLight = true;
        
        final BootstrapButton newDestinationButton = (BootstrapButton) findViewById(R.id.newDestinationButton);
        final BootstrapButton reScanDirectionsButton = (BootstrapButton) findViewById(R.id.reScanDirectionsButton);
        final BootstrapButton mainmenuButton = (BootstrapButton) findViewById(R.id.mainMenuButton);
    	
    	//reScanDirectionsButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
        //newDestinationButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
       
        setText();
        
        reScanDirectionsButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
                IntentIntegrator.initiateScan(GetDirections.this, zxingLibConfig);
                
            }
        });
        
        newDestinationButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            	Intent intent = new Intent(GetDirections.this, ChooseDestination.class);
            	
            	intent.putExtra("scanResult", ChooseDestination.getBeginning());
            	
                startActivity(intent);
            	
            }
        });
        
        mainmenuButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            	Intent intent = new Intent(GetDirections.this, MainActivity.class);
            	
            	intent.putExtra("scanResult", ChooseDestination.getBeginning());
            	
                startActivity(intent);
            	
            }
        });
	}	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.get_directions, menu);
		return true;
	}
	
	 @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);
	        switch (requestCode) {
	            case IntentIntegrator.REQUEST_CODE: // æ‰«æ��ç»“æžœ
	                IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode,
	                        resultCode, data);
	                if (scanResult == null || scanResult.getContents() == "" || scanResult.getContents() == null) {
	                	
	                	showQRCodeError();
	                    return;
	                    
	                }
	                final String result = scanResult.getContents();
	                if (result != null) {
	                    handler.post(new Runnable() {
	                        @Override
	                        public void run() {
	                        	
	                        	scanResultTxt = result;
	                        	
	                        	validateQRCode();                        	
	                        	
	                        }
	                    });
	                }
	                break;
	            default:
	        }        
	        
	    }  
	    
	    private void showQRCodeError(){		
			
			final AlertDialog.Builder qrCodeErrorPopUp = new AlertDialog.Builder(this)
		    .setTitle("QR Code Error")
		    .setMessage("There seems to have been an error while scanning the QR Code. \n\nA team of highly trained monkeys has been dispatched to deal with this situation.")
		    .setPositiveButton("Scan Again.", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		        	IntentIntegrator.initiateScan(GetDirections.this, zxingLibConfig);
		        }
		     })
		     .setNegativeButton("Quit.", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		        	Intent intent = new Intent(GetDirections.this, MainActivity.class);
		            startActivity(intent);
		        }
		     });
			
			qrCodeErrorPopUp.show();
			
		}
	    
	    private void validateQRCode(){
	    	
	    	if(
	    			scanResultTxt.equalsIgnoreCase("Grumbacher ISTC")
		    		|| scanResultTxt.equalsIgnoreCase("MCB/RAB")
		    		|| scanResultTxt.equalsIgnoreCase("Pullo Building (PAC)")
		    		|| scanResultTxt.equalsIgnoreCase("JRR Student Comm. Cntr")
		    		|| scanResultTxt.equalsIgnoreCase("Elias (Science Building)")
		    		|| scanResultTxt.equalsIgnoreCase("Bradley Building")
	    	){
	    		
	    		Intent intent = new Intent(GetDirections.this, ChooseDestination.class);
	        	
	        	intent.putExtra("scanResult", scanResultTxt);
	        	
	            startActivity(intent);    		
	    		   		
	    	}
	    	
	    	else{
	    	
	    		Intent intent= new Intent(GetDirections.this, WrongQRCode.class);
	        	
	            startActivity(intent);
	    		
	    	}    	    	
	    	
	    }
	    
private void setText(){
	    	
	    	//ArrayList<String> directions = new ArrayList<String>();
	    	
	    	DatabaseInterface dbInterface = new DatabaseInterface(ChooseDestination.getDestination(), MainActivity.getScanResult());
	    	
	    	ArrayList<Direction> directionsArray = new ArrayList<Direction>();
	    	dbInterface.setDatabase(mDbHelper);
	    	directionsArray = dbInterface.getBuildingDirections();
	    	
	    	TextView toFrom = (TextView) findViewById(R.id.toFromTextView);
	        
	        TableLayout directionsTable = (TableLayout) findViewById(R.id.directionsTable);
	        
	        toFrom.setText("From: " + ChooseDestination.getBeginning() + " \nTo: " + ChooseDestination.getDestination());
	        
	        for(int x=0; x<directionsArray.size(); x++){
	        	
	        	String directions = "";	        	
	        	String image = "";
	        	
	        	directions = "  " + directionsArray.get(x).getDirectionTxt();
	        	
	        	image = directionsArray.get(x).getDirectionImage();
	        	
	        	TableRow row= new TableRow(this);
	        	//TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
	        	//row.setLayoutParams(lp);
	        	
	        	TextView tv = new TextView(this);
	        	
	        	//tv.setWidth(LayoutParams.WRAP_CONTENT);
	        	
	        	//LinearLayout.LayoutParams childParams = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
	                    //LayoutParams.WRAP_CONTENT);
	        	
	        	//tv.setLayoutParams(childParams);
	        	//row.setLayoutParams(childParams);
	        	tv.setTextColor(Color.BLACK);
	        	
	        	tv.setText(directions);
	        	
	        	if(image.equalsIgnoreCase("straight.jpg")){	        		
	        	
	        		tv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.straight, 0, 0, 0);
	        	
	        	}
	        	
	        	else if(image.equalsIgnoreCase("slight_left.jpg")){	        		
		        	
	        		tv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.slight_left, 0, 0, 0);
	        	
	        	}
	        	
	        	else if(image.equalsIgnoreCase("slight_right.jpg")){	        		
		        	
	        		tv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.slight_right, 0, 0, 0);
	        	
	        	}
	        	
	        	else if(image.equalsIgnoreCase("right_arrow.jpg")){	        		
		        	
	        		tv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.right_arrow, 0, 0, 0);
	        	
	        	}
	        	
	        	else if(image.equalsIgnoreCase("left_arrow.jpg")){	        		
		        	
	        		tv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_arrow, 0, 0, 0);
	        	
	        	}else{
	        		
	        		
	        		tv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.finish, 0, 0, 0);
	        		
	        	}
	        	
	            row.addView(tv);
	            
	            directionsTable.addView(row);
	            
	            //View rule = (View) findViewById(R.id.topRule);
	            
	           //LayoutParams params = (LayoutParams) rule.getLayoutParams();
	            
	            //View view = new View(this);
	            
	           // view.setLayoutParams(params);
	            
	            //view.setBackgroundColor(0x00000000);
	            
	           // directionsTable.addView(view);
	            
	            //TableRow pad= new TableRow(this);
	            
	            //pad.setLayoutParams(params);
	            
	            //TextView text = new TextView(this);
	            
	            //text.setBackgroundColor(Color.BLACK);
	            
	            //text.setText(" ");
	            
	            //pad.addView(text);
	            
	            //directionsTable.addView(pad);
	        }
	        
	        /*mDbHelper.open();
	        directionsTextView1.setText(mDbHelper.getData("Buildings", "b03", "building_info"));
	        mDbHelper.close();
	        */
	        //directionsTextView1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.error, 0, 0, 0);
	        
	    	
	    }
	    
	    public static void setDatabase(TestAdapter abc ){
			
			mDbHelper=abc;
			
		}
}
