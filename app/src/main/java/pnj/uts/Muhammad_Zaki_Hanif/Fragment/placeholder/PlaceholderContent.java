package pnj.uts.Muhammad_Zaki_Hanif.Fragment.placeholder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlaceholderContent {

    public static final List<PlaceholderItem> ITEMS = new ArrayList<PlaceholderItem>();

    public static final Map<String, PlaceholderItem> ITEM_MAP = new HashMap<String, PlaceholderItem>();

        private static final int COUNT = 25;
        private static final String DESKRIPSI= "North Korean leader Kim Jong Un said the negligence and laziness of state officials worsened the country's Covid outbreak, state media reported Wednesday, as the number of known cases crossed 1.7 million. \n\nThe nuclear-armed country reported its first coronavirus cases last week, and the Omicron variant-fuelled outbreak has since ballooned" +
                " -- marking the failure of a two-year blockade maintained since the start of the pandemic.";

        static {
            // Add some sample items.
            for (int i = 1; i <= COUNT; i++) {
                addItem(createPlaceholderItem(i));
            }
        }

        private static void addItem(PlaceholderItem item) {
            ITEMS.add(item);
            ITEM_MAP.put(item.id, item);
        }

        private static PlaceholderItem createPlaceholderItem(int position) {
            return new PlaceholderItem(String.valueOf(position), "Kim slams negligent officials over spiralling N. Korea Covid outbreak ", makeDetails());
        }

        private static String makeDetails() {
            StringBuilder builder = new StringBuilder();
            builder.append(DESKRIPSI).append("\n\nsource: \nhttps://sg.news.yahoo.com/kim-slams-negligent-officials-over-030207553.html");
            return builder.toString();
        }
    public static class PlaceholderItem {
        public final String id;
        public final String content;
        public final String details;

        public PlaceholderItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }


        @Override
        public String toString() {
            return content;
        }
    }
}
