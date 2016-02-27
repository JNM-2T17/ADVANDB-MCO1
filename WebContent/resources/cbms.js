/**
 * 
 */
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
		
		switch(this.query * 1.0) {
			case 1:
				this.input.innerHTML = 
					"Minimum Aggregate: <input name='val' id='val' type='number'  value=0 />";
				this.inputs = ["val"];
				break;
			case 2:
				this.input.innerHTML = 
					"Minimum Aggregate: <input name='val' id='val' type='number'  value=0 /><br/>\
					Minimum Nutritional Index: \
						<select name='minNutIndex' id='minNutIndex'> \
						<option value=1>Above Normal</option> \
						<option value=2>Normal</option> \
						<option value=3>Below Normal (moderate)</option> \
						<option value=4>Below Normal (sever) </option> \
					</select>";
				this.inputs = ["val","minNutIndex"];
				break;
			case 3:
				this.input.innerHTML = 
					"Minimum Aggregate: <input name='val' id='val' type='number'  value=0 /><br/>\
					Cause of Death: \
						<select name='mdeady' id='mdeady'> \
						<option value=1> Diseases of the heart</option> \
						<option value=2> Diseases of the vascular system</option> \
						<option value=3> Pneumonia</option> \
						<option value=4> Tuberculosis</option> \
						<option value=5> Cancer</option> \
						<option value=6> Diarrhea</option> \
						<option value=7> Measles</option> \
						<option value=8> Complication during pregnancy or childbirth</option> \
						<option value=9> Accident (ex. hit by a vehicle)</option> \
						<option value=10> Diabetes</option> \
						<option value=11> Disease of the lungs</option> \
						<option value=12> Disease of the kidney</option> \
						<option value=13> Drowned from flood</option> \
						<option value=14> Victim of landslide</option> \
						<option value=15> Electrocuted during typhoon</option> \
						<option value=16> Murder</option> \
						<option value=17> Other</option> \
					</select>";
				this.inputs = ["val","mdeady"];
				break;
			case 4:
				this.input.innerHTML = 
					"Minimum Aggregate: <input name='val' id='val' type='number'  value=0 /><br/>\
					Aquatic Animal Type: \
						<select name='aquanitype' id='aquanitype'> \
						<option value=1>Tilapia</option> \
						<option value=2>Milkfish</option> \
						<option value=3>Catfish</option> \
						<option value=4>Mudfish</option> \
						<option value=5>Carp</option> \
						<option value=6>Other</option> \
					</select>";
				this.inputs = ["val","aquanitype"];	
				break;
			case 5:
				this.input.innerHTML = 
					"Minimum Aggregate: <input name='val' id='val' type='number'  value=0 /><br/>\
					Crop Type: \
						<select name='croptype' id='croptype'> \
							<option value=1>Sugar Cane</option> \
							<option value=2>Palay</option> \
							<option value=3>Corn</option> \
							<option value=4>Coffee</option> \
							<option value=5>Other Crops</option> \
						</select>";
				this.inputs = ["val","croptype"];	
				break;
			case 6:
				this.input.innerHTML = 
					"Minimum Aggregate: <input name='val' id='val' type='number'  value=0 /><br/>\
					Aquatic Animal Type: \
						<select name='aquanitype' id='aquanitype'> \
							<option value=1>Tilapia</option> \
							<option value=2>Milkfish</option> \
							<option value=3>Catfish</option> \
							<option value=4>Mudfish</option> \
							<option value=5>Carp</option> \
							<option value=6>Other</option> \
						</select><br/>\
					Aquatic Equipment Type: \
						<select name='aquaequiptype' id='aquaequiptype'> \
							<option value=1> Fish net</option> \
							<option value=2> Electricity</option> \
							<option value=3> Bagnets</option> \
							<option value=4> Gillnets</option> \
							<option value=5> Traps</option> \
							<option value=6> Hooks and line</option> \
							<option value=7> Sift net</option> \
							<option value=8> Others</option> \
						</select>";
				this.inputs = ["val","aquanitype","aquaequiptype"];	
				break;
			case 7:
				this.input.innerHTML = 
					"Minimum Aggregate: <input name='val' id='val' type='number'  value=0 />";
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
formManager.updateForm({value : 1});