package wp;


import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.StringValidator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NewsLetter extends WebPage {


    private int nlmsg = 5*5;
    private String nlin = "fsdf";

    private List<String> myData = new ArrayList<>();
    private int i = 0;

    public NewsLetter() {

        for( i=i ;i<50 ; i++) {
            myData.add("d" + i);
        }


        WebMarkupContainer container = new WebMarkupContainer("tab-content");
        add(container);
        Form<Void> form = new Form<>("mynlform");
        Label label = new Label("nl", new PropertyModel<Integer>(this,"nlmsg"));
        TextField<String> textField = new TextField<>("nlin", new PropertyModel<>(this, "nlin"));
        textField.add(StringValidator.lengthBetween(5,10));
        textField.setRequired(true);
        Button sub = new Button("nlsubmit"){
            @Override
            public void onSubmit() {
                System.out.println("submitted.");
            }
        };
        DataView<String> dv = new DataView<String>("list",new ListDataProvider(myData)) {
            @Override
            protected void populateItem(final Item<String> item) {
                String data = item.getModelObject();
                item.add(new Label("c1",data));
                item.add(new Label("c2",data));
            }
        };
        add(form);
        form.add(new FeedbackPanel("feedback"));
        form.add(label);
        form.add(textField);
        form.add(sub);

        container.add(dv);
        dv.setItemsPerPage(10);
        container.add(new PagingNavigator("navigator", dv));
      //  PagingNavigator pager = new PagingNavigator("pager",dv);
       // container.add(pager);
    }



      class DataProvider implements IDataProvider<String> {


        @Override
        public Iterator<String> iterator(long l, long l1) {
            return myData.iterator();
        }

        @Override
        public long size() {
            System.out.println("size: "+myData.size());
            return myData.size();
        }

          @Override
          public IModel<String> model(String s) {
              return new Model(s);
          }


        @Override
        public void detach() {

        }
    }
}
