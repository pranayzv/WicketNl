package wp;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class Home extends WebPage {


    public Home(final PageParameters parameters){
        add(new Label("mylb","Hello World"));

    }

}
