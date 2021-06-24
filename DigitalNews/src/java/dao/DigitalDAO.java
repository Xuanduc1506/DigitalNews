/*
 * Copyright(C)2021, FPT University
 * Lab Java Web
 *
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2021-05-16         1.0               Ducnxhe141626       First Implement
 */
package dao;

import java.util.ArrayList;
import model.Digital;

/**
 * This interface class used to contain some method used to implements in anther
 * class
 *
 * @author Xuan Duc
 */
public interface DigitalDAO {

    /**
     * This method used to get all digital news have title contain the search
     * text form digital table
     *
     * @param title is a <code>String</code>
     * @param pageindex is an <code>int</code>
     * @param pagesize is an <code>int</code>
     * @return digitals is a <code>java.util.ArrayList<></code> object
     * @throws Exception
     */

    public ArrayList<Digital> search(String title, int pageindex, int pagesize) throws Exception;

    /**
     * This method used to get few first digital news form digital table
     *
     * @param numberOfTop is an <code>int</code>
     * @return digitals is a <code>java.util.ArrayList<></code> object
     * @throws Exception
     */
    public ArrayList<Digital> getTop(int numberOfTop) throws Exception;

    /**
     * This method used to get digital news by id form digital table
     *
     * @param id is an <code>int</code>
     * @return dig the object of<code>Digital</code>
     * @throws Exception
     */
    public Digital getDigitalById(int id) throws Exception;

    /**
     * This method used to get number of digital news have title user want form
     * digital table
     *
     * @param title is a <code>String</code>
     * @return count is an <code>int</code>
     * @throws Exception
     */
    public int count(String title) throws Exception;

}
