package payments.stone.com.br.desafiomobile;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import payments.stone.com.br.desafiomobile.cart.CartActivity;
import payments.stone.com.br.desafiomobile.details.DetailsActivity;

import static payments.stone.com.br.desafiomobile.details.DetailsActivity.KEY_DETAILS_PRODUCT_BUNDLE;

/**
 * Created by william.gouvea on 9/22/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements Navigation, BaseView {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_product, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_show_cart:
                startActivity(new Intent(this, CartActivity.class));
                return true;


            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.findItem(R.id.action_search);
        if (menuItem != null) {
            menuItem.setVisible(false);
        }

        return true;
    }

    @Override
    public void whenGoToDetails(Product product) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(KEY_DETAILS_PRODUCT_BUNDLE, product);
        startActivity(intent);
    }

    @Override
    public Context context() {
        return this;
    }
}
