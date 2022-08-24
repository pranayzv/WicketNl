package wa;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.caching.QueryStringWithVersionResourceCachingStrategy;
import wp.Home;
import wp.NewsLetter;


public class News extends WebApplication {

    public News(){

    }

   @Override
    protected void init() {
       mountPage("/news/nl", NewsLetter.class);
       mountPage("/news/nl/home", Home.class);
       //String dbName =  this.getServletContext();
    }



    @Override
    public Class< ? extends WebPage> getHomePage() {
        return Home.class;
    }

}
