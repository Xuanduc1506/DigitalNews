/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function renderPager(id, pageindex, totalpage, gap, txt)
{
    var container = document.getElementById(id);
    if (pageindex > gap + 1)
    {
        container.innerHTML += "<a href='Search?page=1&search=" + txt + "'>First</a>"
    }

    for (var i = pageindex - gap; i < pageindex; i++)
    {
        if (i >= 1)
        {
            container.innerHTML += "<a href='Search?page=" + i + "&search=" + txt + "'>" + i + "</a>"
        }
    }

    container.innerHTML += "<span>" + pageindex + "</span>"

    for (var i = pageindex + 1; i <= pageindex + gap; i++)
    {
        if (i <= totalpage)
        {
            container.innerHTML += "<a href='Search?page=" + i + "&search=" + txt + "'>" + i + "</a>"
        }
    }

    if (pageindex < totalpage - gap)
    {
        container.innerHTML += "<a href='Search?page=" + totalpage + "&search=" + txt + "'>Last</a>"
    }
}

function required1()
{
    var empt = document.getElementById("s").value;
    if (empt.trim() == "")
    {
        alert("Please input a title");
    } else
    {
        return document.getElementById("form").submit();
    }
}



function submitForm()
{
    document.getElementById("frmSearch").submit();
}