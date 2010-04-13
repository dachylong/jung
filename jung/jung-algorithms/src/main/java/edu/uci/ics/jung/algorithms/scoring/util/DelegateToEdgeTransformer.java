/*
 * Created on Jul 11, 2008
 *
 * Copyright (c) 2008, the JUNG Project and the Regents of the University 
 * of California
 * All rights reserved.
 *
 * This software is open-source under the BSD license; see either
 * "license.txt" or
 * http://jung.sourceforge.net/license.txt for a description.
 */
package edu.uci.ics.jung.algorithms.scoring.util;

import com.google.common.base.Function;

/**
 * A <code>Transformer<VEPair,Number></code> that delegates its operation to a
 * <code>Transformer<E,Number></code>.  Mainly useful for technical reasons inside 
 * AbstractIterativeScorer; in essence it allows the edge weight instance 
 * variable to be of type <code>VEPair,W</code> even if the edge weight 
 * <code>Transformer</code> only operates on edges.
 */
public class DelegateToEdgeTransformer<V,E> implements
        Function<VEPair<V,E>,Number>
{
	/**
	 * The Function to which this instance delegates its function.
	 */
    protected Function<? super E,? extends Number> delegate;
    
    /**
     * Creates an instance with the specified delegate Function.
     * @param delegate the Function to which this instance will delegate
     */
    public DelegateToEdgeTransformer(Function<? super E,? extends Number> delegate)
    {
        this.delegate = delegate;
    }
    
    /**
     * @see Function#transform(Object)
     */
    public Number apply(VEPair<V,E> arg0)
    {
        return delegate.apply(arg0.getE());
    }

}
