package abc;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class retrieval {
    public static void main(String[] args) {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("1Heeq4EpxtYYel5AdQIoh7KA1");
        cb.setOAuthConsumerSecret("5Q4tRnme5DUUYRi3jwaV5BdCsmflYvQIzLW0RAghTOdOm1UrPE");
        cb.setOAuthAccessToken("2730637393-Kx1o72FM8EaGYToZ7rAk8vaYjBwBrQnLAfMldjJ");
        cb.setOAuthAccessTokenSecret("yZdyUYjURohL1lwBYV6EJRkJCEmHDUlsCvgra83TO2IFM");

        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();

        StatusListener listener = new StatusListener() {

            @Override
            public void onException(Exception arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onScrubGeo(long arg0, long arg1) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStatus(Status status) {
                User user = status.getUser();
                
                try {
					PrintWriter out = new PrintWriter("filename.txt");
					
					
			dbclass obj=new dbclass();
                // gets Username
			System.out.println();
                String username = status.getUser().getScreenName();
                System.out.println(username);
                out.println(username);
                String profileLocation = user.getLocation();
                System.out.println(profileLocation);
                out.println(profileLocation);
                long tweetId = status.getId(); 
                System.out.println(tweetId);
                out.println(tweetId);
                String content = status.getText();
                
                System.out.println(content +"\n");
                out.println(content +"\n");
                //content=mysql_real_escape_string(content);
                System.out.println(status.getUser().getLang()+"..............");
                if(status.getUser().getLang().equals("en") && profileLocation!=(null))
                		{
                	obj.abc(username, profileLocation, tweetId, content);
                }
              
            	} catch (FileNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               
                
            }

            @Override
            public void onTrackLimitationNotice(int arg0) {
                // TODO Auto-generated method stub

            }

			@Override
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			}

        };
        FilterQuery fq = new FilterQuery();
       
        
        String userInput = null;
        
        try
        {
        //You need to create BufferedReader which has System.in to get user input
        BufferedReader br = new BufferedReader(new
                                InputStreamReader(System.in));
       
        System.out.println("Enter text...");
        System.out.println("Enter 'quit' to quit.");
       //     userInput = (String) br.readLine();
            System.out.println("You entered : " + userInput);
                  }
        catch(Exception e)
        {
        }
        
        String keywords[] = {"a"};

        fq.track(keywords);

        twitterStream.addListener(listener);
        twitterStream.filter(fq);  
        

    }
}
