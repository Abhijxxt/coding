
function Content() {
    return (
        <div id="block1">
            <h1>This is from block 1.</h1>
            <p>This is being printed from block 1.</p>
        </div>
    )
}
//Function names initial should be in Capital letter
ReactDOM.render(
    <div>
        <h1>Hello</h1>
        <p>This is from renderer.</p>
        <Content /> 
    </div>
    , 
    document.getElementById("root")
)