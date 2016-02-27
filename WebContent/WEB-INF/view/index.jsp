<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="theForm" onSubmit="return formManager.check()">
		<select id="querySelect" onChange="formManager.updateForm(this);">
			<option value="1" selected>Average OFW's Per Nuclear Family</option>
			<option value="2">Number of Children above a Particular Nutritional Index</option>
			<option value="3">Average Age of Death Divided by Sex and Geographical Location</option>
			<option value="4">Amount of Fish per Type Caught</option>
			<option value="5">Crop Densities</option>
			<option value="6">Amount of Aquatic Animals Caught Per Type of Aquatic Equipment</option>
			<option value="7">Number of Common Philhealth Beneficiaries</option>
		</select><br/>
		<select name="type">
			<option value="1" selected>Base</option>
			<option value="2">Heuristic Optimization</option>
			<option value="3">Indices</option>
			<option value="4">Views</option>
			<option value="5">Stored Procedures</option>
		</select>
		<div id="inputForm"></div>
		<div id="errors"></div>
		<input type="submit" value="Run Query" />
	</form>
	<script>
		function FormManager() {
			this.query = 1;
			this.form = document.getElementById("theForm");
			this.input = document.getElementById("inputForm");
			this.error = document.getElementById("errors");
			this.map = {
				"val" : "Minimum Aggregate",
				"minNutIndex" : "Minimum Nutritional Index",
				"mdeady" : "Cause of Death",
				"aquanitype" : "Aquatic Animal Type",
				"croptype" : "Crop Type",
				"aquaequiptype" : "Aquatic Equipment Type"
			};
			this.inputs;
			
			this.updateForm = function(choice) {
				this.query = choice.value;
				this.form.action = "BaseQuery" + this.query;
				console.log(this.query);
				switch(this.query * 1.0) {
					case 1:
						this.input.innerHTML = 
							"Minimum Aggregate: <input name='val' id='val' type='number' />";
						this.inputs = ["val"];
						break;
					case 2:
						this.input.innerHTML = 
							"Minimum Aggregate: <input name='val' id='val' type='number' /><br/>\
							Minimum Nutritional Index: \
								<select name="minNutIndex" id="minNutIndex"> \
								<option val=1>Above Normal</option> \
								<option val=2>Normal</option> \
								<option val=3>Below Normal (moderate)</option> \
								<option val=4>Below Normal (sever) </option> \
							</select>";
						this.inputs = ["val","minNutIndex"];
						break;
					case 3:
						this.input.innerHTML = 
							"Minimum Aggregate: <input name='val' id='val' type='number' /><br/>\
							Cause of Death: \
								<select name="mdeady" id="mdeady"> \
								<option val=1> Diseases of the heart</option> \
								<option val=2> Diseases of the vascular system</option> \
								<option val=3> Pneumonia</option> \
								<option val=4> Tuberculosis</option> \
								<option val=5> Cancer</option> \
								<option val=6> Diarrhea</option> \
								<option val=7> Measles</option> \
								<option val=8> Complication during pregnancy or childbirth</option> \
								<option val=9> Accident (ex. hit by a vehicle)</option> \
								<option val=10> Diabetes</option> \
								<option val=11> Disease of the lungs</option> \
								<option val=12> Disease of the kidney</option> \
								<option val=13> Drowned from flood</option> \
								<option val=14> Victim of landslide</option> \
								<option val=15> Electrocuted during typhoon</option> \
								<option val=16> Murder</option> \
								<option val=17> Other</option> \
							</select>";
						this.inputs = ["val","mdeady"];
						break;
					case 4:
						this.input.innerHTML = 
							"Minimum Aggregate: <input name='val' id='val' type='number' /><br/>\
							Aquatic Animal Type: \
								<select name="aquanitype" id="aquanitype"> \
								<option val=1>Tilapia</option> \
								<option val=2>Milkfish</option> \
								<option val=3>Catfish</option> \
								<option val=4>Mudfish</option> \
								<option val=5>Carp</option> \
								<option val=6>Other</option> \
							</select>";
						this.inputs = ["val","aquanitype"];	
						break;
					case 5:
						this.input.innerHTML = 
							"Minimum Aggregate: <input name='val' id='val' type='number' /><br/>\
							Crop Type: \
								<select name="croptype" id="croptype"> \
									<option val=1>Sugar Cane</option> \
									<option val=2>Palay</option> \
									<option val=3>Corn</option> \
									<option val=4>Coffee</option> \
									<option val=5>Other Crops</option> \
								</select>";
						this.inputs = ["val","croptype"];	
						break;
					case 6:
						this.input.innerHTML = 
							"Minimum Aggregate: <input name='val' id='val' type='number' /><br/>\
							Aquatic Animal Type: \
												<select name="aquanitype" id="aquanitype"> \
													<option val=1>Tilapia</option> \
													<option val=2>Milkfish</option> \
													<option val=3>Catfish</option> \
													<option val=4>Mudfish</option> \
													<option val=5>Carp</option> \
													<option val=6>Other</option> \
												</select><br/>\
							Aquatic Equipment Type: \
								<select name="aquaequiptype" id="aquaequiptype"> \
									<option val=1> Fish net</option> \
									<option val=2> Electricity</option> \
									<option val=3> Bagnets</option> \
									<option val=4> Gillnets</option> \
									<option val=5> Traps</option> \
									<option val=6> Hooks and line</option> \
									<option val=7> Sift net</option> \
									<option val=8> Others</option> \
								</select>";
						this.inputs = ["val","aquanitype","aquaequiptype"];	
						break;
					case 7:
						this.input.innerHTML = 
							"Minimum Aggregate: <input name='val' id='val' type='number' />";
						this.inputs = ["val"];	
						break;
					default:	
				}
			}
			
			this.check = function() {
				var error = "";
				for(v in this.inputs) {
					var input = document.getElementById(this.inputs[v]);
					var val = input.value;
					if( !(/[0-9]+/.test(val)) ) {
						error += this.map[this.inputs[v]] + " should be a number.<br/>";
					}
				}
				if( error.length == 0 ) {
					return true;
				} else {
					this.error.innerHTML = error;
					return false;
				}
			}
		}
		var formManager = new FormManager();
		console.log(formManager);
		formManager.updateForm({value : 1});
	</script>
</body>
</html>