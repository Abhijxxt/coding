
function Content1() {
    return (
        <div id="block1">
            <h1>Hello React</h1>
            <p>This is being printed from block 1.</p>
        </div>
    )
}
function Content2() {
    return (
        <div>
            <h2>This is from block 2.</h2>
        </div>
    )
}
//Function names initial should be in Capital letter
ReactDOM.render(
    <div>
        <h1>Hello</h1>
        <Content1 /> 
        <Content2 />
    </div>
    , 
    document.getElementById("root")
)