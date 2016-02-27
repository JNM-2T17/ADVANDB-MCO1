package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import model.AvgDeathAge;
import model.AvgOFWsPerNuclearFamily;
import model.CatchRatio;
import model.CommonBeneficiary;
import model.CropVolume;
import model.FishCount;
import model.HealthyKids;

public class SPQueries {
	public static Collection<AvgOFWsPerNuclearFamily> getAvgOFWsPerNuclearFamilyWithOFWCountGreaterThan(int val){
		ArrayList<AvgOFWsPerNuclearFamily> list = new ArrayList<>();
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(
							"CALL query1(?)");
			statement.setInt(1, val);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				AvgOFWsPerNuclearFamily res = new AvgOFWsPerNuclearFamily(
						resultSet.getString(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getString(4), 
						resultSet.getInt(5), 
						resultSet.getInt(6), 
						resultSet.getDouble(7));
				list.add(res);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static Collection<HealthyKids> getPlacesWithHealthyKidsGreaterThan(int val,int minNutIndex){
		ArrayList<HealthyKids> list = new ArrayList<>();
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(
					"CALL query2(?,?)");
			statement.setInt(1, minNutIndex);
			statement.setInt(2, val);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				HealthyKids res = new HealthyKids(
						resultSet.getString(1), 
						resultSet.getString(2), 
						resultSet.getInt(3), 
						resultSet.getInt(4));
				list.add(res);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static Collection<AvgDeathAge> getAvgDeathAgeGreaterThan(int val,int deady){
		ArrayList<AvgDeathAge> list = new ArrayList<>();
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(
					"CALL query3(?,?)");
			statement.setInt(1, deady);
			statement.setInt(2, val);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				AvgDeathAge res = new AvgDeathAge(
						resultSet.getString(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getInt(4), 
						resultSet.getDouble(5));
				list.add(res);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static Collection<FishCount> getFishCountsGreaterThan(int val, int aquanitype){
		ArrayList<FishCount> list = new ArrayList<>();
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(
					"CALL query4(?,?)");
			statement.setInt(1, aquanitype);
			statement.setInt(2, val);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				FishCount res = new FishCount(
						resultSet.getString(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getInt(4));
				list.add(res);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static Collection<CropVolume> getCropVolumesGreaterThan(double val, int croptype){
		ArrayList<CropVolume> list = new ArrayList<>();
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(
					"CALL query5(?,?)");
			statement.setDouble(1, croptype);
			statement.setDouble(2, val);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				CropVolume res = new CropVolume(
						resultSet.getString(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getInt(4), 
						resultSet.getInt(5), 
						resultSet.getDouble(6));
				list.add(res);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static Collection<CatchRatio> getCatchRatiosGreaterThan(double val, int aquaequiptype, int aquanitype){
		ArrayList<CatchRatio> list = new ArrayList<>();
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(
					"CALL query6(?,?,?)");
			statement.setInt(1, aquaequiptype);
			statement.setInt(2, aquanitype);
			statement.setDouble(3, val);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				CatchRatio res = new CatchRatio(
						resultSet.getString(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getLong(4), 
						resultSet.getLong(5), 
						resultSet.getDouble(6));
				list.add(res);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static Collection<CommonBeneficiary> getCommonBeneficiariesGreaterThan(int val){
		ArrayList<CommonBeneficiary> list = new ArrayList<>();
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(
					"CALL query7(?)");
			statement.setInt(1, val);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				CommonBeneficiary res = new CommonBeneficiary(
						resultSet.getString(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getInt(4));
				list.add(res);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static void createIndexesForQuery1(){
		Connection connection = DBManager.getInstance().getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("CREATE INDEX HIndex"
					+ " ON db_hpq.hpq_hh (nnucfam)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dropIndexesForQuery1(){
		Connection connection = DBManager.getInstance().getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("ALTER TABLE hpq_hh DROP INDEX HIndex");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createIndexesForQuery2(){
		Connection connection = DBManager.getInstance().getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("CREATE INDEX HIndex"
					+ " ON db_hpq.hpq_mem (mnutind)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dropIndexesForQuery2(){
		Connection connection = DBManager.getInstance().getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("ALTER TABLE hpq_mem DROP INDEX HIndex");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createIndexesForQuery3(){
		Connection connection = DBManager.getInstance().getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("CREATE INDEX HIndex2"
					+ " ON db_hpq.hpq_death (mdeady)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dropIndexesForQuery3(){
		Connection connection = DBManager.getInstance().getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("ALTER TABLE hpq_death DROP INDEX HIndex2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createIndexesForQuery4(){
		Connection connection = DBManager.getInstance().getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("CREATE INDEX HIndex2"
					+ " ON db_hpq.hpq_aquani (aquanitype)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dropIndexesForQuery4(){
		Connection connection = DBManager.getInstance().getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("ALTER TABLE hpq_aquani DROP INDEX HIndex2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createIndexesForQuery5(){
		Connection connection = DBManager.getInstance().getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("CREATE INDEX HIndex3"
					+ " ON db_hpq.hpq_crop (croptype)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dropIndexesForQuery5(){
		Connection connection = DBManager.getInstance().getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("ALTER TABLE hpq_crop DROP INDEX HIndex3");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createIndexesForQuery6(){
		Connection connection = DBManager.getInstance().getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("CREATE INDEX HIndex2"
					+ " ON db_hpq.hpq_aquaequip (aquaequiptype)");
			statement.executeUpdate("CREATE INDEX HIndex3"
					+ " ON db_hpq.hpq_aquani (aquanitype)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dropIndexesForQuery6(){
		Connection connection = DBManager.getInstance().getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("ALTER TABLE hpq_aquaequip DROP INDEX HIndex2");
			statement.executeUpdate("ALTER TABLE hpq_aquani DROP INDEX HIndex3");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createIndexesForQuery7(){
		Connection connection = DBManager.getInstance().getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("CREATE INDEX hpq_phiheal_spon_memidx_1"
					+ " ON hpq_phiheal_spon_mem(phiheal_spon_mem_refno)");
			statement.executeUpdate("CREATE INDEX hpq_phiheal_empl_memidx_1"
					+ " ON hpq_phiheal_empl_mem(phiheal_empl_mem_refno)");
			statement.executeUpdate("CREATE INDEX hpq_phiheal_indiv_memidx_1"
					+ " ON hpq_phiheal_indiv_mem(phiheal_indiv_mem_refno)");
			statement.executeUpdate("CREATE INDEX hpq_phiheal_life_memidx_1"
					+ " ON hpq_phiheal_life_mem(phiheal_life_mem_refno)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dropIndexesForQuery7(){
		Connection connection = DBManager.getInstance().getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("DROP INDEX hpq_phiheal_spon_memidx_1"
					+ " ON hpq_phiheal_spon_mem;");
			statement.executeUpdate("DROP INDEX hpq_phiheal_empl_memidx_1"
					+ " ON hpq_phiheal_empl_mem");
			statement.executeUpdate("DROP INDEX hpq_phiheal_indiv_memidx_1"
					+ " ON hpq_phiheal_indiv_mem");
			statement.executeUpdate("DROP INDEX hpq_phiheal_life_memidx_1"
					+ " ON hpq_phiheal_life_mem");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
