/*
 * Copyright(C)2021, FPT University
 * Lab Java Web
 *
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2021-05-16         1.0               Ducnxhe141626       First Implement
 */
package dao.impl;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Digital;
import dao.DigitalDAO;
import java.sql.SQLException;

/**
 * This class used to get info from digital table
 *
 * @author Xuan Duc
 */
public class DigitalDAOImpl extends DBContext implements DigitalDAO {

    /**
     * This method used to get all digital news have title contain the search
     * text form digital table
     *
     * @param title it is a <code>String</code>
     * @param pageindex it is an <code>int</code>
     * @param pagesize it is an <code>int</code>
     * @return digitals it is a <code>java.util.ArrayList<></code> object
     * @throws Exception
     */
    @Override
    public ArrayList<Digital> search(String title, int pageindex, int pagesize) throws Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Digital> digitals = new ArrayList<>();
        String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY id ASC) as rid,* \n"
                + "                    FROM digital WHERE title LIKE ? ) tbl \n"
                + "                    WHERE rid >= (? - 1)*? + 1\n"
                + "                    AND rid <= ? * ?";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + title + "%");
            ps.setInt(2, pageindex);
            ps.setInt(3, pagesize);
            ps.setInt(4, pagesize);
            ps.setInt(5, pageindex);
            rs = ps.executeQuery();
            while (rs.next()) {
                Digital dig = new Digital();
                dig.setId(rs.getInt(2));
                dig.setTitle(rs.getString(3));
                dig.setContent(rs.getString(4));
                dig.setImage(rs.getString(5));
                dig.setAuthor(rs.getString(6));
                dig.setDate(rs.getString(7));
                dig.setShortContent(rs.getString(8));
                digitals.add(dig);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return digitals;
    }

    /**
     * This method used to get few first digital news form digital table
     *
     * @param numberOfTop is an <code>int</code>
     * @return digitals is a <code>java.util.ArrayList<></code> object
     * @throws Exception
     */
    @Override
    public ArrayList<Digital> getTop(int numberOfTop) throws Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Digital> digitals = new ArrayList<>();
        String sql = "SELECT TOP(?) * FROM digital ORDER BY date";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, numberOfTop);
            rs = ps.executeQuery();
            while (rs.next()) {
                Digital dig = new Digital();
                dig.setId(rs.getInt(1));
                dig.setTitle(rs.getString(2));
                dig.setContent(rs.getString(3));
                dig.setImage(rs.getString(4));
                dig.setAuthor(rs.getString(5));
                dig.setDate(rs.getString(6));
                dig.setShortContent(rs.getString(7));
                digitals.add(dig);
            }
            return digitals;

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    /**
     * This method used to get digital news by id form digital table
     *
     * @param id is an <code>int</code>
     * @return dig is a <code>Digital</code> object
     * @throws Exception
     */
    @Override
    public Digital getDigitalById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM digital WHERE id = '" + id + "'";
        Digital dig = new Digital();
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dig.setId(id);
                dig.setTitle(rs.getString(2));
                dig.setContent(rs.getString(3));
                dig.setImage(rs.getString(4));
                dig.setAuthor(rs.getString(5));
                dig.setDate(rs.getString(6));
                dig.setShortContent(rs.getString(7));
            }
            return dig;
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }

    }

    /**
     * This method used to get number of digital news have title user want form
     * digital table
     *
     * @param title is a <code>String</code>
     * @return count is an <code>int</code>
     * @throws Exception
     */
    @Override
    public int count(String title) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) as total FROM digital WHERE title LIKE ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + title + "%");
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return 0;
    }

}
