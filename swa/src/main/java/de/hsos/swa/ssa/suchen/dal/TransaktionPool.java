package de.hsos.swa.ssa.suchen.dal;

import java.sql.ResultSet;

public interface TransaktionPool {
    public boolean create(String sql);

    public ResultSet read(String sql);

    public boolean update(String sql);

    public boolean delete(String sql);
}
