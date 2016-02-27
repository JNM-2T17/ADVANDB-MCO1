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
							Minimum Nutritional Index: <input name='minNutIndex' id='minNutIndex' type='number' />";
						this.inputs = ["val","minNutIndex"];
						break;
					case 3:
						this.input.innerHTML = 
							"Minimum Aggregate: <input name='val' id='val' type='number' /><br/>\
							Cause of Death: <input name='mdeady' id='mdeady' type='number' />";
						this.inputs = ["val","mdeady"];
						break;
					case 4:
						this.input.innerHTML = 
							"Minimum Aggregate: <input name='val' id='val' type='number' /><br/>\
							Aquatic Animal Type: <input name='aquanitype' id='aquanitype' type='number' />";
						this.inputs = ["val","aquanitype"];	
						break;
					case 5:
						this.input.innerHTML = 
							"Minimum Aggregate: <input name='val' id='val' type='number' /><br/>\
							Crop Type: <input name='croptype' id='croptype' type='number' />";
						this.inputs = ["val","croptype"];	
						break;
					case 6:
						this.input.innerHTML = 
							"Minimum Aggregate: <input name='val' id='val' type='number' /><br/>\
							Aquatic Animal Type: <input name='aquanitype' id='aquanitype' type='number' /><br/>\
							Aquatic Equipment Type: <input name='aquaequiptype' id='aquaequiptype' type='number' />";
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
					console.log(!(/[0-9]+/.test(val)));
					if( !(/[0-9]+/.test(val)) ) {
						error += this.map[this.inputs[v]] + " should be a number.<br/>";
						console.log("Error: " + error);
					}
				}
				console.log(error);
				console.log(error.length);
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