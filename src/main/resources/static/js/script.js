var headers = /*[[${columnHeaders}]]*/ [];
var columnSelect = document.getElementById('columnSelect');
var dataTable = document.querySelector('.table');
var countsRow = document.getElementById('countsRow');

columnSelect.addEventListener('change', function() {
    var column = this.value;

    // Reset table to original state
    var cells = dataTable.querySelectorAll('tbody td');
    cells.forEach(function(cell) {
        cell.style.backgroundColor = ''; // Remove any background color
        cell.style.color = ''; // Reset text color
    });

    // Highlight selected column
    var selectedCells = dataTable.querySelectorAll('tbody td[data-column="' + column + '"]');
    selectedCells.forEach(function(cell) {
        cell.style.backgroundColor = 'lightblue'; // Highlight background color
        cell.style.color = 'black'; // Set text color to black
    });

    // Count occurrences of each name in the selected column
    var nameCount = {};
    selectedCells.forEach(function(cell) {
        var name = cell.textContent.trim();
        if (nameCount[name]) {
            nameCount[name]++;
        } else {
            nameCount[name] = 1;
        }
    });

    // Display the name counts
    var countDisplay = '';
    for (var name in nameCount) {
        countDisplay += name + ': ' + nameCount[name] + '<br>';
    }
    document.getElementById('nameCounts').innerHTML = countDisplay;

    // Show the label and counts row
    countsRow.style.display = 'block';
});
