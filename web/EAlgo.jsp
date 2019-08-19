<!DOCTYPE html>
<meta charset="utf-8">
<style>
html, body {
	height: 100%;
}

body {
	margin: 0;
	padding: 0;
	overflow: hidden;
	font-size: 12px;
	font-family: Arial, sans-serif;
}

#maindiv {
	width: 960px;
	height: 380px;
}

.dataset-a, .dataset-b {
	display: inline-block;
	width: 400px;
	padding: 0 0 0 50px;
}

#button {
	margin: 20px 50px;
}

#error {
	margin: 20px 50px;
	font-size: 20px;
	color: red;
}
</style>
<body>
    <script src="Contents/js/moebio_framework.min.js" type="text/javascript"></script>

<script>
	var uniform = [0.2334, 0.4229, 0.2938, 0.9500, 0.3745, 0.3985, 0.3158, 0.4228, 0.2844, 0.3871, 0.5104, 0.3336, 0.2984, 0.2859, 0.4372, 0.8939, 0.4119, 0.5078, 0.9713, 0.3784, 0.3209, 0.3385, 0.5550, 0.5868, 0.3276, 0.8119, 0.7752, 0.9800, 0.5759, 0.3898, 0.4301, 0.3909, 0.4792, 0.4215, 0.6487, 0.0861, 0.1373, 0.1443, 0.2952, 0.2803, 0.1996, 0.1195, 0.1100, 0.0133, 0.2272, 0.2399, 0.1183, 0.1424, 0.1873, 0.1649, 0.8907, 0.9081, 0.8240, 0.8495, 0.9040, 0.7813, 0.6995, 0.8918, 0.8165, 0.9883];
	var clustered = [0.5249, 0.6735, 0.5593, 0.4187, 0.6349, 0.4788, 0.4559, 0.4861, 0.5759, 0.4410, 0.5357, 0.4725, 0.6527, 0.4988, 0.3397, 0.4526, 0.4674, 0.6161, 0.5081, 0.5519, 0.5172, 0.5021, 0.4984, 0.5105, 0.8681, 0.7942, 0.8389, 0.8748, 0.8194, 0.9015, 0.8505, 0.7642, 0.9134, 0.8259, 0.8268, 0.7230, 0.8689, 0.8446, 0.7744, 0.8332, 0.8390, 0.8287, 0.1935, 0.2151, 0.0994, 0.1380, 0.1832, 0.1630, 0.1317, 0.1394, 0.2956, 0.2004, 0.1353, 0.2359, 0.1413, 0.1669, 0.1399, 0.1719, 0.1799, 0.1672];
	var elbowData = {};
	var maxK = 10;
	var newData = false;
	var g;

	function computeData() {
		// Reset elbowData
		elbowData = {};
                

		uniformNL = mo.NumberList.fromArray(uniform);
		clusteredNL = mo.NumberList.fromArray(clustered);

		// Compute k-means clusters for k from 1 to 10, and populate the elbowData
		// for each dataset and each value of k
		for (var k = 1; k <= maxK; ++k) {
			uniformKMeans = mo.NumberListOperators.linearKMeans(uniformNL, k);
			clusteredKMeans = mo.NumberListOperators.linearKMeans(clusteredNL, k);

			function SSE(datasetName, numClusters) {
				return function(dataset) {
					// Sum up the sum of squared errors for each cluster
					sse = 0;
					for (var c = 0; c < dataset.length; ++c) {
						mean = dataset[c].getAverage();
						sse += dataset[c].subtract(mean).pow(2).getNorm();
					}

					elbowData[datasetName] = elbowData[datasetName] || [];
					elbowData[datasetName].push([numClusters, sse]);
				}
			}

			// Compute sum of squared errors for each cluster
			SSE('uniform', k)(uniformKMeans);
			SSE('clustered', k)(clusteredKMeans);
		}
	}

	function drawNumberLine(g, dataset, label, offset) {
		var lineLen = 350;
		var tickLen = 5;
		var x = 50 + (offset || 0);
		var y = 80;
		var radius = 5;

		var min = 0;
		var max = 1;

		if (newData) {
			min = mo.NumberList.fromArray(dataset).getMin();
			max = mo.NumberList.fromArray(dataset).getMax();
		}

		var range = max - min;

		g.setStroke('#777');
		g.setFill('rgba(125,125,125,0.5)');

		// x-axis
		g.line(x, y, x + lineLen, y);
		// Ticks
		g.line(x, y, x, y + tickLen);
		g.line(x + lineLen / 2, y, x + lineLen / 2, y + tickLen);
		g.line(x + lineLen, y, x + lineLen, y + tickLen);

		// Draw each data point
		dataset.forEach(function(d) {
			g.fCircle(x + ((d - min) / range) * lineLen, y - 1.5 * radius, radius);
		})

		// Labels
		g.setText('#555', 12, 'Arial', "center");
		g.fText(min.toFixed(2), x, y + tickLen);
		g.fText(((min + max) / 2).toFixed(2), x + lineLen / 2, y + tickLen);
		g.fText(max.toFixed(2), x + lineLen, y + tickLen);

		g.setText('#555', 16, 'Arial', 'center', 'bottom', 'bold');
		g.fText(label, x + lineLen / 2, y - 4 * radius);
	}

	function drawElbowChart(g, datasetName, offset) {
		var xLineLen = 350;
		var yLineLen = 200;
		var tickLen = 5;
		var x = 50 + (offset || 0);
		var y = 130;
		var elbow = elbowData[datasetName];
		var sseMax = elbow.map(function(pair) { return pair[1] });
		sseMax = mo.NumberList.fromArray(sseMax).getMax();

		g.setStroke("#777");

		// Draw axes
		g.line(x, y + yLineLen, x + xLineLen, y + yLineLen);
		g.line(x, y + yLineLen, x, y)

		// x-axis ticks and labels
		for (var i = 1; i <= maxK; ++i) {
			var xTick = Math.floor((i / maxK) * xLineLen);
			g.line(x + xTick, y + yLineLen, x + xTick, y + yLineLen + tickLen);
			g.setText('#555', 12, 'Arial', "center");
			g.fText(i, x + xTick, y + yLineLen + tickLen);
		}

		// Axis title
		g.fText("Number of clusters (k)", x + xLineLen / 2, y + yLineLen + tickLen + 12);
		g.fTextRotated("Sum of squared errors", x - 16, y + yLineLen / 2, -Math.PI / 2);

		g.setStroke("#333");

		// Draw sum of square errors
		for (var i = 1; i < elbow.length; ++i) {
			var a = elbow[i - 1];
			var b = elbow[i];
			var xA = (a[0] / maxK) * xLineLen + x;
			var yA = (1 - a[1] / sseMax) * yLineLen + y;
			var xB = (b[0] / maxK) * xLineLen + x;
			var yB = (1 - b[1] / sseMax) * yLineLen + y;
			g.line(xA, yA, xB, yB);
		}
	}

	function setup() {
		g = new mo.Graphics({
			container: "#maindiv",
			dimensions: {
				width: 960,
				height: 380
			},
			init: computeData,
			cycle: function() {
				this.setText('#555', 10, 'Arial', 'center', 'bottom', 'bold');
				this.fText("K-means clustering SSE vs. number of clusters for two random datasets", 450, 20);
				this.setStroke("#aaa");
				this.line(150, 25, 750, 25);
				drawNumberLine(this, clustered, "Dataset A");
				drawNumberLine(this, uniform, "Dataset B", 450);
				drawElbowChart(this, 'clustered');
				drawElbowChart(this, 'uniform', 450);
			}
		});
		g.setBackgroundColor('white');
	}

	function inputChange() {
		function parseInput(id) {
			input = document.getElementById("input-" + id);
			value = input.value;

			dataset = value.split(",").map(function(d) {
				val = Number(d);
				if (isNaN(val) || !isFinite(val) || d.trim().length === 0) {
					throw "Error parsing Dataset " + id.toUpperCase();
				}
				return val;
			});

			if (id == "a") {
				clustered = dataset;
			} else {
				uniform = dataset;
			}
		}

		try {
			var id = "a";
			parseInput(id);
			id = "b";
			parseInput(id);

			computeData();

			newData = true;

			var errorDiv = document.getElementById('error');
			error.innerHTML = "";
		} catch (e) {
			var errorDiv = document.getElementById('error');
			error.innerHTML = e;
		}
	}

	window.onload = function() {
		var inputA = document.getElementById('input-a');
		var inputB = document.getElementById('input-b');
		
		inputA.value = clustered.join(", ");
		inputB.value = uniform.join(", ");

		setup();
	}
</script>
<div id="maindiv"></div>
<div class="dataset-a">
	Dataset A: <input type="text" id="input-a" size="45">
</div>
<div class="dataset-b">
	Dataset B: <input type="text" id="input-b" size="45">
</div>
<div id="button">
	<button type="button" onclick="inputChange()">Parse datasets</button>
</div>
<div id="error"></div>