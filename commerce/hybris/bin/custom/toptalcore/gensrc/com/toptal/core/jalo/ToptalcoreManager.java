/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Aug. 7, 2022, 9:54:02 a.m.                  ---
 * ----------------------------------------------------------------
 */
package com.toptal.core.jalo;

import com.toptal.core.constants.ToptalcoreConstants;
import de.hybris.platform.directpersistence.annotation.SLDSafe;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.extension.ExtensionManager;
import de.hybris.platform.jalo.product.Product;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type <code>ToptalcoreManager</code>.
 */
@SuppressWarnings({"unused","cast"})
@SLDSafe
public class ToptalcoreManager extends Extension
{
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put("calories", AttributeMode.INITIAL);
		tmp.put("extImg", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.product.Product", Collections.unmodifiableMap(tmp));
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.calories</code> attribute.
	 * @return the calories
	 */
	public String getCalories(final SessionContext ctx, final Product item)
	{
		return (String)item.getProperty( ctx, ToptalcoreConstants.Attributes.Product.CALORIES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.calories</code> attribute.
	 * @return the calories
	 */
	public String getCalories(final Product item)
	{
		return getCalories( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.calories</code> attribute. 
	 * @param value the calories
	 */
	public void setCalories(final SessionContext ctx, final Product item, final String value)
	{
		item.setProperty(ctx, ToptalcoreConstants.Attributes.Product.CALORIES,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.calories</code> attribute. 
	 * @param value the calories
	 */
	public void setCalories(final Product item, final String value)
	{
		setCalories( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.extImg</code> attribute.
	 * @return the extImg
	 */
	public String getExtImg(final SessionContext ctx, final Product item)
	{
		return (String)item.getProperty( ctx, ToptalcoreConstants.Attributes.Product.EXTIMG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.extImg</code> attribute.
	 * @return the extImg
	 */
	public String getExtImg(final Product item)
	{
		return getExtImg( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.extImg</code> attribute. 
	 * @param value the extImg
	 */
	public void setExtImg(final SessionContext ctx, final Product item, final String value)
	{
		item.setProperty(ctx, ToptalcoreConstants.Attributes.Product.EXTIMG,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.extImg</code> attribute. 
	 * @param value the extImg
	 */
	public void setExtImg(final Product item, final String value)
	{
		setExtImg( getSession().getSessionContext(), item, value );
	}
	
	public static final ToptalcoreManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (ToptalcoreManager) em.getExtension(ToptalcoreConstants.EXTENSIONNAME);
	}
	
	@Override
	public String getName()
	{
		return ToptalcoreConstants.EXTENSIONNAME;
	}
	
}
