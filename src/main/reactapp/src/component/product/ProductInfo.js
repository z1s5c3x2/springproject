// npm istall @mui/x-charts
import { BarChart } from '@mui/x-charts/BarChart';  // 막대차트
import { PieChart } from '@mui/x-charts/PieChart';  // 원형차트
import axios from 'axios';
import {useState, useEffect} from 'react';


export default function ProductInfo( props ){

    const [barchartData, setBarchartData] = useState([])
    const [piechartData, setPiechartData] = useState([])
    // 1. 막대차트에 필요한 데이터 요청
    const getBarchart = e => {
        axios.get("/product/barchart")
            .then( r=> {
                console.log( r.data )
                setBarchartData(r.data)
            })
    }
    useEffect( () => {
        getBarchart()
    }, [] )

    // 2. 원형차트에 필요한 데이터 요청
    const getPieChart = e => {
        axios.get("/product/piechart")
            .then( r=> {
                console.log( r.data )
                setPiechartData (r.data )
            })
    }

    useEffect( () => {
        getPieChart()
    }, [] )

    return (<>
        <div style={{ display : 'flex' }}>
            <div>
                <h3> 제품별 재고 수 (막대차트) </h3>
                {barchartData.length > 0 && <BarChart
                    xAxis={[
                        {
                            id: 'barCategories',
                            data: barchartData.map((p) => {
                                return p.p_name
                            }),
                            scaleType: 'band',
                        },
                    ]}
                    series={[
                        {
                            data: barchartData.map((p) => {
                                return p.p_stock
                            }),
                        },
                    ]}
                    width={500} height={300}
                />}

            </div>
            <div>
                <h3> 카테고리별 제품 수 (원형차트) </h3>
                { piechartData.length > 0 && <PieChart
                    series={[
                        {
                            data:
                                piechartData.map( (p,c) =>{
                                    return {id:c,value:p.p_cnt,label:p.pc_name}
                                })
                                /*{id: 0, value: 10, label: 'series A'},
                                {id: 1, value: 15, label: 'series B'},
                                {id: 2, value: 20, label: 'series C'},*/
                            ,
                        },
                    ]}
                    width={400} height={200}
                />}

            </div>
        </div>
    </>)
}