package com.ibm.timetable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.timetable.Connection;

public class Crud {

	public void inserttime(Double start, Double end) throws SQLException {

		String sql = "{call time()}";
		java.sql.CallableStatement s;
		s = Connection.conn.prepareCall(sql);
		s.execute();

		int count = 1;
		while (start < end) {

			PreparedStatement stmt = Connection.conn.prepareStatement
		   ("insert into timetable(time,mon,tue,wed,thrus,fri) values(?,?,?,?,?,?)");
			stmt.setDouble(1, start);
			stmt.setString(2, start+",mon");
			stmt.setString(3, start+",tue");
			stmt.setString(4, start+",wed");
			stmt.setString(5, start+",thrus");
			stmt.setString(6, start+",fri");
			stmt.executeUpdate();

			if (count == 2)
			{
				start += 1.3;
			}
			else
				start++;

			count++;
		}
	}

	public List<TimeTable> fetchtime() throws SQLException {
		String query = "SELECT * FROM timetable";
		ResultSet results = Connection.conn.createStatement().executeQuery(query);
		List<TimeTable> Time = new ArrayList<TimeTable>();
		while (results.next()) {
			Time.add(new TimeTable(results.getDouble("time"),results.getString("mon"),results.getString("tue"),
					results.getString("wed"),results.getString("thrus"),results.getString("fri")));
		}
		return Time;
	}

	public List<Trainer> fetchTrainer() throws SQLException {
		String query = "SELECT * FROM trainer group by t_name";
		ResultSet results = Connection.conn.createStatement().executeQuery(query);
		List<Trainer> trainer = new ArrayList<Trainer>();
		while (results.next()) {
			trainer.add(new Trainer(results.getString("t_name"), results.getString("t_sub")));
		}
		return trainer;
	}

	public List<Trainer> fetchSubject(String sub) throws SQLException {
		String query = "SELECT t_sub,t_name FROM trainer where t_sub=?";
		PreparedStatement stmt = Connection.conn.prepareStatement(query);
		stmt.setString(1, sub);
		stmt.execute();
		ResultSet results = stmt.getResultSet();
		List<Trainer> subject = new ArrayList<Trainer>();
		while (results.next()) {
			subject.add(new Trainer(results.getString("t_name"), results.getString("t_sub")));
		}
		return subject;
	}

	public void Update(String trainer, String subject, double time, String week) throws SQLException {
		StringBuilder query = new StringBuilder("Update timetable set ");
		query.append(week);
		query.append("=");
		query.append("'");
		query.append(trainer+","+ subject);
		query.append("'");
		query.append(" where time = ?");
		PreparedStatement stmt = Connection.conn.prepareStatement(query.toString());
		stmt.setDouble(1, time);
		stmt.execute();
		System.out.println("Table Updated");
	}

}
