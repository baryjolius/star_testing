$.fn.clearSelect = function() {
    return this.each(function() {
        if (this.tagName == 'SELECT')
            this.options.length = 0;
    });
 } 
 


$.fn.fillSelect = function(data,_codeField,_displayField) {
    return this.clearSelect().each(function() {
        if (this.tagName == 'SELECT') {
            var dropdownList = this;
            dropdownList.add(Option("Sila Pilih",""));
            $.each(data, function(index, optionData) {            	
                var option = new Option(eval("optionData."+_displayField), eval("optionData."+_codeField));
                
                if ($.browser.msie) {
                    dropdownList.add(option);
                }
                else {
                    dropdownList.add(option, null);
                }
            });
        }
    });
 }

$.fn.fillSelect2 = function(data,_codeField,_displayField) {
    return this.clearSelect().each(function() {
        if (this.tagName == 'SELECT') {
            var dropdownList = this;
            dropdownList.add(Option("Sila Pilih",""));
            $.each(data, function(index, optionData) {
                var option = new Option(eval("optionData."+_displayField), eval("optionData."+_codeField));
                
                if ($.browser.msie) {
                    dropdownList.add(option);
                }
                else {
                    dropdownList.add(option, null);
                }
            });
        }
    });
 }