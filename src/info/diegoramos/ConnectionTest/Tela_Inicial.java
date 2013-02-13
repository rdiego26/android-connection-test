package info.diegoramos.ConnectionTest;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Toast;

public class Tela_Inicial extends Activity
	{
   
	
	public static void testConnection(Context ctx) {
        try
        {
            ConnectivityManager cm = (ConnectivityManager)
       		ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
            
            String Message; //Será usada no Toast
            
            if (cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnected())
            {
            		Message = "Conectado a Internet 3G ";
            }
            else if(cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected())
            {
            		Message = "Conectado a Internet WIFI ";
            }
            else
            {
            		Message = "Não possui conexão com a internet ";
            }
            
            Toast.makeText(ctx, Message, Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
        	Toast.makeText(ctx, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }	
	
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
        testConnection(this);
    
    }
}