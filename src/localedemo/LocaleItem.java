/*
 * LocaleItem.java
 *
 * Created on 2006/10/16, 16:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package localedemo;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import sun.util.locale.provider.LocaleProviderAdapter;

/**
 *
 * @author naoto
 */
public class LocaleItem implements Comparable<LocaleItem> {
    private Locale locale;
    private LocaleProviderAdapter.Type type = LocaleProviderAdapter.Type.JRE;
/*
    Class<LocaleServiceProvider>[] providerClasses =
                        (Class<LocaleServiceProvider>[]) new Class<?>[] {
                java.util.spi.CalendarDataProvider.class,
                java.text.spi.DateFormatProvider.class,
                java.text.spi.DateFormatSymbolsProvider.class,
                java.text.spi.DecimalFormatSymbolsProvider.class,
                java.text.spi.NumberFormatProvider.class,
                java.util.spi.CurrencyNameProvider.class,
                java.util.spi.LocaleNameProvider.class,
                java.text.spi.BreakIteratorProvider.class,
                java.text.spi.CollatorProvider.class,
                java.util.spi.TimeZoneNameProvider.class,
            };
*/
    /** Creates a new instance of LocaleItem */

    /**
     * Creates a new instance of LocaleItem
     * @param l
     */
    public LocaleItem(Locale l) {
        locale = l;

        // this is not necessarily correct.
/*
        for (Class<LocaleServiceProvider> c : providerClasses) {
            LocaleProviderAdapter lda = LocaleServiceProviderPool.getPool(c).getAdapter(l);
            if (lda != null) {
                type = lda.getAdapterType();
                break;
            }
        }
*/
        for (LocaleProviderAdapter.Type t : LocaleProviderAdapter.getAdapterPreference()) {
            LocaleProviderAdapter lpa = LocaleProviderAdapter.forType(t);
            Locale[] locales = lpa.getAvailableLocales();
            if (locales != null) {
                List<Locale> avail = Arrays.asList(locales);
                if (avail.contains(l)) {
                    type = t;
                    break;
                }
            }
        }
    }

    public Locale getLocale() {
        return locale;
    }

    public LocaleProviderAdapter.Type getAdapterType() {
        return type;
    }

    @Override
    public String toString() {
        return locale.getDisplayName();
    }

    @Override
    public int compareTo(LocaleItem other) {
        return locale.getDisplayName().compareTo(other.getLocale().getDisplayName());
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof LocaleItem)) {
            return false;
        }

        return locale.equals(((LocaleItem)other).getLocale());
    }

    @Override
    public int hashCode() {
        return locale.hashCode();
    }
}