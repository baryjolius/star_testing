
function promptAlert(message){
	var displayPanel = '<p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>' + message + '</p>';
	var $dialog = $('<div></div>')
	.html(displayPanel)
	.dialog({
		resizable: false,
		autoOpen: false,
		dialogClass: 'alert',
		modal: true,
		title: 'Alert',
		buttons: {
			"Tutup": function(){
				$(this).dialog("close");
			}
		}
	});

	$dialog.dialog('open');
}

function promptMessage(message){
	var $dialog = $('<div></div>')
	.html(message)
	.dialog({
		resizable: false,
		autoOpen: false,
		dialogClass: 'alert',
		modal: true,
		title: 'Alert',
		buttons: {
			"Tutup": function(){
				$(this).dialog("close");
			}
		}
	});

	$dialog.dialog('open');
}

function reloadComboBox(combobox, data, config){
	combobox.html("");
	var _options = eval("data." + config.datasource);
	
	combobox.append("<option value>" + config.firstOption + "</option");
	
	if(typeof _option == "undefined"){
		var _value = eval("data." + config.value);
		var _description = eval("data." + config.display);
		combobox.append("<option value=\"" + _value + "\">" + _description + "</option");
	}else{
		$.each(_options, function(index, item){
			var _value = eval("item." + config.value);
			var _description = eval("item." + config.display);
			combobox.append("<option value=\"" + _value + "\">" + _description + "</option");
		});
	}
}

/* Extend jQuery with functions for PUT and DELETE requests. */
function _ajax_request(url, data, callback, type, method,error) {
    if (jQuery.isFunction(data)) {
        callback = data;
        data = {};
    }
    return jQuery.ajax({
        type: method,
        url: url,
        data: data,
        success: callback,
        dataType: type,
        error:error
        });
}

jQuery.extend({
    put: function(url, data, callback, type,error) {
        return _ajax_request(url, data, callback, type, 'PUT');
    },
    delete_: function(url, data, callback, type,error) {
        return _ajax_request(url, data, callback, type, 'DELETE');
    }
});

function loadDropDown(_item,_id,_codeField,_name,_displayField){
	var updateURL = document.getElementById("getDataUrl").value;
	$.getJSON(updateURL,{item:_item,id:_id},
			function(response){
		//$("#"+_name).fillSelect(response,_codeField,_displayField);
		eval("reload_"+_name+"(response)");
	});

}

function loadDropDown2(_item,_id,_codeField,_name,_displayField){
	var updateURL = document.getElementById("getDataUrl").value;
	$.getJSON(updateURL,{item:_item,id:_id},
			function(response){
		eval("reload_"+_name+"(response)");
	});
}
	
function loadDropDown3(_item,_valueId,_name){
	var updateURL = document.getElementById("getDataUrl").value;
	$.getJSON(updateURL,{item:_item,id:_valueId},
			function(response){
		eval("reload_"+_name+"(response)");
	});
}

function loadDropDown4(params,_name){
	var updateURL = document.getElementById("getDataUrl").value;
	var urlData = updateURL+"?"+params;
	$.getJSON(urlData,
			function(response){
		eval("reload_"+_name+"(response)");
	});
}
