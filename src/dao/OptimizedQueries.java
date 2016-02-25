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

public class OptimizedQueries {
	public static Collection<AvgOFWsPerNuclearFamily> getAvgOFWsPerNuclearFamilyWithOFWCountGreaterThan(int val){
		ArrayList<AvgOFWsPerNuclearFamily> list = new ArrayList<>();
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(
							"SELECT mun, zone, brgy, purok"
							+ ", SUM(nnucfam) AS `Nuclear Families`, SUM(nofw) AS OFWs"
							+ ", SUM(nofw) / SUM(nnucfam) AS `Average OFW's per Nuclear Family`"
							+ " FROM (SELECT mun, zone, brgy, purok, nnucfam, nofw"
							+ " FROM db_hpq.hpq_hh"
							+ " WHERE nnucfam > 0) A"
							+ " GROUP BY mun, zone, brgy, purok"
							+ " HAVING SUM(nofw) > ?");
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
					"SELECT country_resid, prov_resid_code, mnutind,COUNT(mnutind) nutCount"
					+ " FROM (SELECT country_resid, prof_resid_code, mnutind"
					+ " FROM hpq_mem"
					+ " WHERE mnutind <= ?)"
					+ " GROUP BY country_resid, prov_resid_code,mnutind"
					+ " HAVING nutCount > ?)");
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
	
	public static Collection<AvgDeathAge> getAvgDeathAgeGraterThan(int val){
		ArrayList<AvgDeathAge> list = new ArrayList<>();
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(
					"SELECT H.mun,H.zone,H.brgy, mdeadsx, AVG(mdeadage) avg_death_age"
					+ " FROM (SELECT id, mun, zone, brgy"
					+ " FROM hpq_hh)H INNER JOIN "
					+ " (SELECT hpq_hh_id, mdeadsx, mdeadage "
					+ " FROM hpq_death) D "
					+ " ON H.id = D.hpq_hh_id"
					+ " GROUP BY H.mun,H.zone,H.brgy,mdeadsx"
					+ " HAVING AVG(mdeadage) > ?");
			statement.setInt(1, val);
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
					"SELECT H.mun,H.zone,H.brgy, aquanitype, COUNT(H.id) fishcount"
					+ " FROM (SELECT id,mun,zone,brgy "
					+ " FROM hpq_hh) H INNER JOIN "
					+ " (SELECT hpq_hh_id, aquanitype "
					+ " FROM hpq_aquani"
					+ " WHERE aquanitype = ?) A"
					+ " ON H.id = A.hpq_hh_id"
					+ " GROUP BY H.mun,H.zone,H.brgy,aquanitype"
					+ " HAVING COUNT(H.id) > ?");
			statement.setInt(1, aquanitype);
			statement.setInt(2, val);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				FishCount res = new FishCount(
						resultSet.getString(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getInt(4), 
						resultSet.getInt(5));
				list.add(res);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static Collection<CropVolume> getCropVolumesGreaterThan(double val){
		ArrayList<CropVolume> list = new ArrayList<>();
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(
					"SELECT H.mun,H.zone,H.brgy, SUM(crop_vol) AS totalcrop"
					+ ", SUM(alp_area) AS totalArea"
					+ ", SUM(crop_vol)/SUM(alp_area) AS cropDensity"
					+ " FROM (SELECT id,mun,zone,brgy"
					+ " FROM hpq_hh) H INNER JOIN"
					+ " ((SELECT hpq_hh_id,alp_area "
					+ " FROM hpq_alp ) A INNER JOIN "
					+ " (SELECT hpq_hh_id,crop_vol"
					+ " FROM hpq_crop) C "
					+ " ON A.hpq_hh_id = C.hpq_hh_id) "
					+ " ON H.id = A.hpq_hh_id"
					+ " GROUP BY H.mun,H.zone,H.brgy"
					+ " HAVING cropDensity > ?");
			statement.setDouble(1, val);
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
					"select mun, zone, brgy,SUM(aquaequip_line) AS totalequip"
					+ "		, SUM(aquani_vol) AS totalvol"
					+ "        , SUM(aquani_vol)/SUM(aquaequip_line) AS CatchPerEquip"
					+ " from ((SELECT hpq_hh_id,aquaequip_line"
					+ "		FROM hpq_aquaequip"
					+ "        WHERE aquaequiptype = ?) AA INNER JOIN"
					+ "	(SELECT hpq_hh_id, aquani_vol "
					+ "		FROM hpq_aquani"
					+ "        WHERE aquanitype = ?)AP"
					+ "	ON AA.hpq_hh_id = AP.hpq_hh_id) INNER JOIN"
					+ "    (SELECT id, mun, zone, brgy"
					+ "		FROM hpq_hh) H"
					+ "	ON H.id = AA.hpq_hh_id"
					+ " group by H.mun,H.zone,H.brgy"
					+ " having catchperequip > 0");
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
	
	public static Collection<CommonBeneficiary> getCommonBeneficiariesGraterThan(int val){
		ArrayList<CommonBeneficiary> list = new ArrayList<>();
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(
					"SELECT H.mun,H.zone,H.brgy,COUNT(H.id) benefCount"
					+ " FROM (SELECT id, mun, zone, brgy "
					+ " FROM hpq_hh) H INNER JOIN "
					+ " ((((SELECT hpq_hh_id, phiheal_spon_mem_refno"
					+ " FROM hpq_phiheal_spon_mem)PSM INNER JOIN"
					+ " (SELECT hpq_hh_id, phiheal_empl_mem_refno "
					+ " FROM hpq_phiheal_empl_mem )PEM"
					+ " ON PSM.hpq_hh_id = PEM.hpq_hh_id"
					+ " AND PSM.phiheal_spon_mem_refno = PEM.phiheal_empl_mem_refno) INNER JOIN"
					+ " (SELECT hpq_hh_id, phiheal_indiv_mem_refno "
					+ " FROM hpq_phiheal_indiv_mem )PIM "
					+ " ON PEM.hpq_hh_id = PIM.hpq_hh_id"
					+ " AND PEM.phiheal_empl_mem_refno = PIM.phiheal_indiv_mem_refno) INNER JOIN"
					+ " (SELECT hpq_hh_id, phiheal_life_mem_refno"
					+ " FROM hpq_phiheal_life_mem ) PLM"
					+ " ON PIM.hpq_hh_id = PLM.hpq_hh_id"
					+ " AND PIM.phiheal_indiv_mem_refno = PLM.phiheal_life_mem_refno )"
					+ " ON id = PSM.hpq_hh_id"
					+ " GROUP BY H.mun,H.zone,H.brgy"
					+ " HAVING benefCount > ?");
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
}
