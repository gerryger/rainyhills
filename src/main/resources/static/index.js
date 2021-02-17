$(document).ready(function(e){
	$('#calculate-button').click(function(e){
	    const volumesInput = $('#volumes-input').val();
	    const volumes = volumesInput.trim().replace(/\s+/g, ',');
	    $.ajax({
	    	type: "POST",
	    	contentType: "application/json",
	    	url: "/volume-service/calculate",
	    	data: '{ "hills": [ '+ volumes +' ] }',
	    	dataType: 'json',
	    	success: function(response) {
	    		console.log("Volume is " + response.volume);
	    		$('#result').html(response.volume);
	    		$('#result-text').css("visibility", "visible");
	    	}
	    });
	});
});

function validateInput() {
    const volumesInput = $('#volumes-input').val();
    const button = $('#calculate-button');
    const volumesInputContent = volumesInput.trim();
    if (/^[0-9 ]+$/.test(volumesInputContent)) {
        button.removeAttr("disabled");
    } else {
        button.attr("disabled", true);
        alert('invalid input!');
    }
}