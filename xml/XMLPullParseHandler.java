import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
 
public class XMLPullParserHandler {
    List<Group> groups;
    private Group group;
    private String text;
 
    public XMLPullParserHandler() {
        groups = new ArrayList<Group>();
    }
 
    public List<Group> getGroups() {
        return groups;
    }
 
    public List<Group> parse(InputStream is) {
        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            parser = factory.newPullParser();
 
            parser.setInput(is, null);
 
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                Log.d("Paser", tagname);
                switch (eventType) {
                case XmlPullParser.START_TAG:
                    if (tagname.equalsIgnoreCase("group")) {
                    	
                        // create a new instance of group
                        group = new Group();
                    }
                    break;
 
                case XmlPullParser.TEXT:
                    text = parser.getText();
                    break;
 
                case XmlPullParser.END_TAG:
                    if (tagname.equalsIgnoreCase("group")) {
                        // add group object to list
                        groups.add(group);
                    } else if (tagname.equalsIgnoreCase("id")) {
                        group.setId(Integer.parseInt(text));
                    } else if (tagname.equalsIgnoreCase("title")) {
                        group.setTitle(text);
                    } else if (tagname.equalsIgnoreCase("subject")) {
                        group.setSubject(text);
                    } else if (tagname.equalsIgnoreCase("description")) {
                        group.setDescription(text);
                    } else if (tagname.equalsIgnoreCase("address")) {
                        group.setAddress(text);
                    } else if (tagname.equalsIgnoreCase("addressAddition")) {
                        group.setAddressAddition(text);
                    } else if (tagname.equalsIgnoreCase("duration")) {
                        group.setDuration(Integer.parseInt(text));
                    } else if (tagname.equalsIgnoreCase("peopleIn")) {
                        group.setPeopleIn(Integer.parseInt(text));
                    } else if (tagname.equalsIgnoreCase("checkIn")) {
                        group.setCheckIn(Integer.parseInt(text));
                    } else if (tagname.equalsIgnoreCase("school")) {
                        group.setSchool(text);
                    } else if (tagname.equalsIgnoreCase("creatorId")) {
                        group.setCreatorId(text);
                    } else if (tagname.equalsIgnoreCase("creatorName")) {
                        group.setCreatorName(text);
                    }
                    break;
 
                default:
                    break;
                }
                eventType = parser.next();
            }
 
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        return groups;
    }
}