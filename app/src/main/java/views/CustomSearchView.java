package views;

import android.content.Context;
import android.support.v7.widget.SearchView;
import android.view.KeyEvent;

public class CustomSearchView extends SearchView {
    public CustomSearchView(final Context context) {
        super(context);
        this.setIconifiedByDefault(true);
    }

    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK &&
                event.getAction() == KeyEvent.ACTION_UP) {
            this.onActionViewCollapsed();
        }
        return super.dispatchKeyEventPreIme(event);
    }
}