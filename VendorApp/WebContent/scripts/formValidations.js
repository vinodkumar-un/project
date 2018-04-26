function resetLocInputMsg() {
	document.getElementById("locNameErr").inneHTML = '';
	document.getElementById("locTypeErr").inneHTML = '';
}

function doValidateLoc() {

	var lname = /^[a-zA-Z]{2,12}$/;
	resetLocInputMsg();
	if (!(document.locationform.locName.value.match(lname))) {
		document.getElementById("locNameErr").innerHTML = '** invalid location name';
		return false;
	}
	if (document.locationform.locType[0].checked == false
			&& document.locationform.locType[1].checked == false) {
		document.getElementById("locTypeErr").innerHTML = '** invalid location type';
		return false;
	}
	return true;
}
